package com.thoughtworks.gilederose.store;

import com.thoughtworks.gilederose.entity.AbstractProduct;
import com.thoughtworks.gilederose.entity.NormalProduct;
import com.thoughtworks.gilederose.entity.SpecialProduct;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
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

    @Test
    public void should_return_correct_sellIn_and_quantity_given_sellIn_and_quantity_when_update_normal_product_and_special_product() {
        NormalProduct product1 = new NormalProduct(10L, BigDecimal.valueOf(20));
        NormalProduct product2 = new NormalProduct(2L, BigDecimal.ZERO);
        NormalProduct product3 = new NormalProduct(3L, BigDecimal.valueOf(6));
        NormalProduct product4 = new NormalProduct(0L, BigDecimal.valueOf(6));
        NormalProduct product5 = new NormalProduct(-1L, BigDecimal.valueOf(6));
        SpecialProduct product6 = new SpecialProduct(15L, BigDecimal.valueOf(20));
        SpecialProduct product7 = new SpecialProduct(10L, BigDecimal.valueOf(45));
        SpecialProduct product8 = new SpecialProduct(9L, BigDecimal.valueOf(45));
        SpecialProduct product9 = new SpecialProduct(10L, BigDecimal.valueOf(49));
        SpecialProduct product10 = new SpecialProduct(10L, BigDecimal.valueOf(50));
        SpecialProduct product11 = new SpecialProduct(5L, BigDecimal.valueOf(49));
        SpecialProduct product12 = new SpecialProduct(5L, BigDecimal.valueOf(45));
        SpecialProduct product13 = new SpecialProduct(1L, BigDecimal.valueOf(20));
        SpecialProduct product14 = new SpecialProduct(0L, BigDecimal.valueOf(20));
        Store store = new Store();
        store.addProducts(Arrays.asList(product1, product2, product3, product4, product5,
                product6, product7, product8, product9, product10, product11, product12, product13, product14));

        store.updateProduct();

        List<AbstractProduct> products = store.getProducts();

        assertEquals(14, products.size());
        assertEquals(9, products.get(0).getSellIn());
        assertEquals(BigDecimal.valueOf(19), products.get(0).getQuality());
        assertEquals(1, products.get(1).getSellIn());
        assertEquals(BigDecimal.valueOf(0), products.get(1).getQuality());
        assertEquals(2, products.get(2).getSellIn());
        assertEquals(BigDecimal.valueOf(5), products.get(2).getQuality());
        assertEquals(-1, products.get(3).getSellIn());
        assertEquals(BigDecimal.valueOf(4), products.get(3).getQuality());
        assertEquals(-2, products.get(4).getSellIn());
        assertEquals(BigDecimal.valueOf(4), products.get(4).getQuality());

        assertEquals(14, products.get(5).getSellIn());
        assertEquals(BigDecimal.valueOf(21), products.get(5).getQuality());
        assertEquals(9, products.get(6).getSellIn());
        assertEquals(BigDecimal.valueOf(47), products.get(6).getQuality());
        assertEquals(8, products.get(7).getSellIn());
        assertEquals(BigDecimal.valueOf(47), products.get(7).getQuality());
        assertEquals(9, products.get(8).getSellIn());
        assertEquals(BigDecimal.valueOf(50), products.get(8).getQuality());
        assertEquals(9, products.get(9).getSellIn());
        assertEquals(BigDecimal.valueOf(50), products.get(9).getQuality());
        assertEquals(4, products.get(10).getSellIn());
        assertEquals(BigDecimal.valueOf(50), products.get(10).getQuality());
        assertEquals(4, products.get(11).getSellIn());
        assertEquals(BigDecimal.valueOf(48), products.get(11).getQuality());
        assertEquals(0, products.get(12).getSellIn());
        assertEquals(BigDecimal.valueOf(23), products.get(12).getQuality());
        assertEquals(-1, products.get(13).getSellIn());
        assertEquals(BigDecimal.ZERO, products.get(13).getQuality());
    }
}
