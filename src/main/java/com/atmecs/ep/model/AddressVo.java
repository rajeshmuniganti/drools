package com.atmecs.ep.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.ALWAYS)
public class AddressVo {
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
}
