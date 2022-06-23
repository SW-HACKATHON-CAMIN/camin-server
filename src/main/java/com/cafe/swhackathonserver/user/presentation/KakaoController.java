package com.cafe.swhackathonserver.user.presentation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/api/auth/kakao")
public class KakaoController {
    @RequestMapping("")
    @ResponseBody
    public String redirectKakaoLogin() {
        return "<div style='text-align: center;'><img style='width: 50px;\n"
                + "    margin: 0;\n"
                + "    position: absolute;\n"
                + "    top: 50%;\n"
                + "    -ms-transform: translateY(-50%);\n"
                + "    transform: translateY(-50%);' src='https://c.tenor.com/I6kN-6X7nhAAAAAj/loading-buffering.gif'></div>";
    }

}
