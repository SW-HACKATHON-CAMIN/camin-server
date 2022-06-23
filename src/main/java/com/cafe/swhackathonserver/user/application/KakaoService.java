package com.cafe.swhackathonserver.user.application;

import com.cafe.swhackathonserver.exception.user.KakaoTokenNotFoundException;
import com.cafe.swhackathonserver.user.application.dto.KakaoUserResponse;
import com.cafe.swhackathonserver.util.WebUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoService {

    private final WebUtil webUtil;

    @Value("${kakao.client-id}")
    public String KAKAO_CLIENT_ID;

    @Value("${kakao.client-secret}")
    public String KAKAO_CLIENT_SECRET;

    @Value("${kakao.redirect-url}")
    public String KAKAO_CLIENT_REDIRECT_URL;

    @Value("${kakao.token-api}")
    public String KAKAO_TOKEN_API;

    @Value("${kakao.user-api}")
    public String KAKAO_USER_API;

    public String getTokenByCode(String code) {
        String token = "";
        try {
            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            // 파라미터 설정
            HttpEntity<MultiValueMap<String, String>> parameter = getTokenParameter(headers, code);

            Map<String, String> response = webUtil
                    .requestApi(KAKAO_TOKEN_API, HttpMethod.POST, parameter);

            token = response.get("access_token");
            if (token == null || token.equals("")) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            throw new KakaoTokenNotFoundException();
        }

        return token;
    }

    public KakaoUserResponse getKakaoUserInfoByToken(String token) {
        KakaoUserResponse kakaoUserResponse;
        try {
            URL url = new URL(KAKAO_USER_API);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            String line = "";
            String result = "";

            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            String platformId = element.getAsJsonObject().get("id").getAsString();
            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            String nickName = properties.get("nickname").getAsString();
            String profileImageUrl = properties.get("profile_image").getAsString();

            JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
            String email =
                    kakaoAccount.get("has_email").getAsBoolean() ? kakaoAccount.get("email")
                            .getAsString() : "";
            kakaoUserResponse = new KakaoUserResponse(platformId, profileImageUrl, nickName, email);
        } catch (Exception e) {
            throw new KakaoTokenNotFoundException();
        }

        return kakaoUserResponse;
    }

    public HttpEntity<MultiValueMap<String, String>> getTokenParameter(HttpHeaders headers,
                                                                       String code) {
        // 파라미터 설정
        MultiValueMap<String, String> paramter = new LinkedMultiValueMap<>();
        paramter.add("grant_type", "authorization_code");
        paramter.add("client_id", KAKAO_CLIENT_ID);
        paramter.add("redirect_uri", KAKAO_CLIENT_REDIRECT_URL);
        paramter.add("code", code);
        paramter.add("client_secret", KAKAO_CLIENT_SECRET);

        return new HttpEntity<>(paramter, headers);
    }

    public HttpEntity<MultiValueMap<String, String>> getUserParameter(HttpHeaders headers) {
        // 파라미터 설정
        MultiValueMap<String, String> paramter = new LinkedMultiValueMap<>();
        return new HttpEntity<>(paramter, headers);
    }

}
