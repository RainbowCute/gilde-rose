package com.thoughtworks.gilederose.store;

import com.thoughtworks.gilederose.entity.AbstractProduct;
import com.thoughtworks.gilederose.entity.NormalProduct;
import com.thoughtworks.gilederose.entity.SpecialProduct;
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

    @Test
    public void should_return_sellIn_minus_1_and_quantity_minus_2_given_sellIn_is_0_and_quantity_is_10_when_update_normal_product() {
        NormalProduct product = new NormalProduct(0L, BigDecimal.valueOf(10));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(-1, products.get(0).getSellIn());
        assertEquals(BigDecimal.valueOf(8), products.get(0).getQuality());
    }

    @Test
    public void should_return_sellIn_minus_1_and_quantity_is_0_given_sellIn_is_0_and_quantity_is_1_when_update_normal_product() {
        NormalProduct product = new NormalProduct(0L, BigDecimal.ONE);
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(-1, products.get(0).getSellIn());
        assertEquals(BigDecimal.ZERO, products.get(0).getQuality());
    }

    @Test
    public void should_return_sellIn_minus_1_and_quantity_add_1_given_sellIn_is_15_and_quantity_is_10_when_update_special_product() {
        SpecialProduct product = new SpecialProduct(15L, BigDecimal.valueOf(10));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(14, products.get(0).getSellIn());
        assertEquals(BigDecimal.valueOf(11), products.get(0).getQuality());
    }

    @Test
    public void should_return_sellIn_minus_1_and_quantity_add_2_given_sellIn_is_10_and_quantity_is_10_when_update_special_product() {
        SpecialProduct product = new SpecialProduct(10L, BigDecimal.valueOf(10));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(9, products.get(0).getSellIn());
        assertEquals(BigDecimal.valueOf(12), products.get(0).getQuality());
    }

    @Test
    public void should_return_sellIn_minus_1_and_quantity_add_3_given_sellIn_is_5_and_quantity_is_10_when_update_special_product() {
        SpecialProduct product = new SpecialProduct(5L, BigDecimal.valueOf(10));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(4, products.get(0).getSellIn());
        assertEquals(BigDecimal.valueOf(13), products.get(0).getQuality());
    }

    @Test
    public void should_return_sellIn_minus_1_and_quantity_is_0_given_sellIn_is_0_and_quantity_is_10_when_update_special_product() {
        SpecialProduct product = new SpecialProduct(0L, BigDecimal.valueOf(10));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(-1, products.get(0).getSellIn());
        assertEquals(BigDecimal.ZERO, products.get(0).getQuality());
    }

    @Test
    public void should_return_sellIn_minus_1_and_quantity_is_50_given_sellIn_is_5_and_quantity_is_49_when_update_special_product() {
        SpecialProduct product = new SpecialProduct(5L, BigDecimal.valueOf(49));
        Store store = new Store();
        store.addProduct(product);

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(1, products.size());
        assertEquals(4, products.get(0).getSellIn());
        assertEquals(BigDecimal.valueOf(50), products.get(0).getQuality());
    }
}
