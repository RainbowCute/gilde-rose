package com.thoughtworks.gilederose.entity;

import java.math.BigDecimal;

public class SpecialProduct extends AbstractProduct{
    public SpecialProduct(Long sellIn, BigDecimal quality) {
        super(sellIn, quality);
    }
}
