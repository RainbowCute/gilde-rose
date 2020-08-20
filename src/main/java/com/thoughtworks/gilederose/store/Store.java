package com.thoughtworks.gilederose.store;

import com.thoughtworks.gilederose.entity.AbstractProduct;
import com.thoughtworks.gilederose.entity.NormalProduct;
import com.thoughtworks.gilederose.entity.SpecialProduct;
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
            updateSellIn(item);
            updateQuantity(item);
        });
    }

    private void updateSellIn(AbstractProduct product) {
        product.setSellIn(product.getSellIn() - 1);
    }

    private void updateQuantity(AbstractProduct product) {
        if (product instanceof NormalProduct) {
            updateNormalQuantity(product);
        } else if (product instanceof SpecialProduct) {
            updateSpecialQuantity(product);
        }
    }

    private void updateSpecialQuantity(AbstractProduct product) {
        if (product.getSellIn() <= 10) {
            product.setQuality(calculateQuantity(product.getQuality(), BigDecimal.valueOf(2)));
            return;
        }
        product.setQuality(calculateQuantity(product.getQuality(), BigDecimal.ONE));
    }

    private void updateNormalQuantity(AbstractProduct product) {
        if (product.getSellIn() < 0) {
            product.setQuality(calculateQuantity(product.getQuality(), BigDecimal.valueOf(-2)));
            return;
        }
        product.setQuality(calculateQuantity(product.getQuality(), BigDecimal.valueOf(-1)));
    }

    private BigDecimal calculateQuantity(BigDecimal value1, BigDecimal value2) {
        BigDecimal value = value1.add(value2);
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }
        return value;
    }

    public void addProduct(AbstractProduct product) {
        if (Objects.isNull(product)) {
            return;
        }
        products.add(product);
    }
}
