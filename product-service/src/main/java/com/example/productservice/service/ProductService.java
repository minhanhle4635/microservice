package com.example.productservice.service;

import com.example.productservice.controller.dto.response.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProduct(Long id);
}
