package com.cafe.swhackathonserver.cafe.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SectionChangeRequest {
    private Long cafeSectionId;
    private int status;
}
