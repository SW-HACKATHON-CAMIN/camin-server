package com.cafe.swhackathonserver.cafe.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.cafe.swhackathonserver.cafe.application.dto.CafeDetailDto;
import com.cafe.swhackathonserver.cafe.application.dto.CafeSimpleDto;
import com.cafe.swhackathonserver.cafe.domain.Cafe;
import com.cafe.swhackathonserver.cafe.domain.repository.CafeCategoryRepository;
import com.cafe.swhackathonserver.cafe.domain.repository.CafeRepository;
import com.cafe.swhackathonserver.cafe.domain.repository.SectionRepository;
import com.cafe.swhackathonserver.cafe.domain.section.CafeSection;
import com.cafe.swhackathonserver.cafe.domain.section.Section;
import com.cafe.swhackathonserver.cafe.presentation.dto.request.CafeCreateRequest;
import com.cafe.swhackathonserver.category.application.CategoryRepository;
import com.cafe.swhackathonserver.category.domain.CafeCategory;
import com.cafe.swhackathonserver.category.domain.Category;
import com.cafe.swhackathonserver.exception.cafe.CafeNotFoundException;
import com.cafe.swhackathonserver.user.domain.User;
import com.cafe.swhackathonserver.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;
    private final UserRepository userRepository;
    private final SectionRepository sectionRepository;
    private final CategoryRepository categoryRepository;
    private final CafeCategoryRepository cafeCategoryRepository;

    @Transactional
    public Long create(CafeCreateRequest cafeCreateDto) {

        Cafe newCafe = Cafe.builder()
                           .infoImage(cafeCreateDto.getInfoImage())
                           .mainImage(cafeCreateDto.getMainImage())
                           .address(cafeCreateDto.getAddress())
                           .phone(cafeCreateDto.getPhone())
                           .introduction(cafeCreateDto.getIntroduction())
                           .cafeName(cafeCreateDto.getCafeName())
                           .event(cafeCreateDto.getEvent())
                           .latitude(cafeCreateDto.getLatitude())
                           .longitude(cafeCreateDto.getLongitude())
                           .build();


        User user = userRepository.findById(cafeCreateDto.getManagerId()).orElseThrow();
        List<Category> categories = categoryRepository.findAllById(cafeCreateDto.getCategoryIds());
        List<Section> sections = sectionRepository.findAllById(cafeCreateDto.getSectionIds());

        newCafe.setManager(user);
        newCafe.addImages(cafeCreateDto.getCafeImages());
        newCafe.addCategories(categories);
        newCafe.addSections(sections, cafeCreateDto.getSectionCounts());

        Cafe savedCafe = cafeRepository.save(newCafe);
        return savedCafe.getId();
    }

    @Transactional
    public Long delete(Long id) {
        Cafe cafe = cafeRepository.findById(id).orElseThrow(CafeNotFoundException::new);
        cafeRepository.delete(cafe);
        return id;
    }

    @Transactional(readOnly = true)
    public CafeDetailDto findById(Long cafeId, Long userId) {
        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(CafeNotFoundException::new);
        long id = Objects.isNull(userId) ? -1 : userId;
        return new CafeDetailDto(cafe, id);
    }

    @Transactional(readOnly = true)
    public List<CafeSimpleDto> findByFilter(BigDecimal latitude, BigDecimal longitude, List<Long> categoryIds) {
        List<CafeCategory> cafeCategories = cafeCategoryRepository.findCafeByLocationAndFilter(latitude, longitude, categoryIds);
        List<Cafe> cafes = cafeCategories.stream()
                .map(CafeCategory::getCafe)
                .collect(Collectors.toList());
        return cafes.stream()
                .distinct()
                .map(cafe -> new CafeSimpleDto(cafe, getAverageStatus(cafe.getCafeSections())))
                .collect(Collectors.toList());


    }

    private int getAverageStatus(List<CafeSection> cafeSections) {
        int size = cafeSections.size();
        if (size == 0)
            return 0;
        int sum = 0;
        for (CafeSection cafeSection : cafeSections) {
            sum += cafeSection.getStatus();
        }
        if(sum < 2) return 0;
        if(sum < 5) return 1;
        if(sum < 7) return 2;
        return 3;
    }

    @Transactional(readOnly = true)
    public Cafe findCafeById(Long cafeId) {
        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(CafeNotFoundException::new);
        return cafe;
    }

    @Transactional
    public void updateCafe(Long id,String cafeName){
        Cafe cafe = this.findCafeById(id);
        cafe.updateCafeName(cafeName);
    }
}
