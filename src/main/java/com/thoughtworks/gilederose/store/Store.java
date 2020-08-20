package com.thoughtworks.gilederose.store;

import com.thoughtworks.gilederose.entity.AbstractProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Store {

    private final List<AbstractProduct> products = new ArrayList<>();

    public void updateProduct() {
        products.forEach(item -> {
            item.setSellIn(item.getSellIn() - 1);
            item.setQuality(item.getQuality().subtract(BigDecimal.ONE));
        });
    }

    public void addProduct(AbstractProduct product) {
        if (Objects.isNull(product)) {
            return;
        }
        products.add(product);
    }
}
