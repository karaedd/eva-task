package com.kraievskyi.evatask.service;

import com.kraievskyi.evatask.model.Product;
import com.kraievskyi.evatask.model.request.ProductCreationRequest;
import java.util.List;

public interface ProductService {
    List<Product> getAllWithRegex(String regex);

    List<Product> getAll();

    Product create(ProductCreationRequest productCreationRequest);
}
