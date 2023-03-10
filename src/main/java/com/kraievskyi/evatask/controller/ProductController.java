package com.kraievskyi.evatask.controller;

import com.kraievskyi.evatask.model.Product;
import com.kraievskyi.evatask.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shop")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllByRegex(@RequestParam String nameFilter) {
        return productService.getAllWithRegex(nameFilter);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }
}
