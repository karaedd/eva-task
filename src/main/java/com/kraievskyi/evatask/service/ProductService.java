package com.kraievskyi.evatask.service;

import com.kraievskyi.evatask.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllWithRegex(String regex);

    List<Product> getAll();
}
