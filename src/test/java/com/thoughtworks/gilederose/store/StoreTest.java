package com.thoughtworks.gilederose.store;

import com.thoughtworks.gilederose.entity.AbstractProduct;
import com.thoughtworks.gilederose.entity.NormalProduct;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void should_return_sellIn_minus_1_and_quantity_minus_1_given_sellIn_is_3_and_quantity_is_10_when_update_normal_product() {
        NormalProduct product = new NormalProduct(3L, BigDecimal.valueOf(10));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(2, products.get(0).getSellIn().longValue());
        assertEquals(BigDecimal.valueOf(9), products.get(0).getQuality());
    }
}
