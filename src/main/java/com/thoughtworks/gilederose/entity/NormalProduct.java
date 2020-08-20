package com.thoughtworks.gilederose.entity;

import java.math.BigDecimal;

public class NormalProduct extends AbstractProduct {
    public NormalProduct(Long sellIn, BigDecimal quality) {
        super(sellIn, quality);
    }
}
