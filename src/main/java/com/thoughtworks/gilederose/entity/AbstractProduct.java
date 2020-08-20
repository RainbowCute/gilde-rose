package com.thoughtworks.gilederose.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbstractProduct {
    private Long sellIn;
    private BigDecimal quality;
}
