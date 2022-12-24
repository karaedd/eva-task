package com.kraievskyi.evatask.service.impl;

import com.kraievskyi.evatask.model.Product;
import com.kraievskyi.evatask.service.ProductService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProductServiceImplTest {

    private static final String REGEX1 = "^E.*$";
    private static final String REGEX2 = "^.*[eva].*$";
    private static ProductService productService;
    private static List<Product> expectedList1;
    private static List<Product> expectedList2;

    @BeforeEach
    void setUp() {
        productService = Mockito.mock(ProductService.class);
        expectedList1 = List.of(
                new Product("Shampoo", "Great shampoo"),
                new Product("Vine", "Rose"),
                new Product("Apple", "Red")
        );
        expectedList2 = List.of(
                new Product("Kiwi", "Green")
        );
    }

    @Test
    void getAllWithRegex() {
        Mockito.when(productService.getAllWithRegex(REGEX1)).thenReturn(expectedList1);
        Mockito.when(productService.getAllWithRegex(REGEX2)).thenReturn(expectedList2);
        List<Product> actualList1 = productService.getAllWithRegex(REGEX1);
        List<Product> actualList2 = productService.getAllWithRegex(REGEX2);

        Assertions.assertEquals(actualList1, expectedList1);
        Assertions.assertEquals(actualList2, expectedList2);
    }
}
