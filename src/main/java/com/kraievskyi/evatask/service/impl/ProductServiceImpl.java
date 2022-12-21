package com.kraievskyi.evatask.service.impl;

import com.kraievskyi.evatask.model.Product;
import com.kraievskyi.evatask.model.request.ProductCreationRequest;
import com.kraievskyi.evatask.repository.ProductRepository;
import com.kraievskyi.evatask.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllWithRegex(String regex) {
        return productRepository.findAll()
                .parallelStream()
                .filter(p -> !p.getName()
                        .matches(regex))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAll() {

        return productRepository.findAll();
    }

    @Override
    public Product create(ProductCreationRequest productCreationRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreationRequest, product);
        return productRepository.save(product);
    }
}
