package com.example.productservice.service.impl;

import com.example.productservice.controller.dto.response.ProductDTO;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(Long id){
        return productMapper.mapToDTO(productRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
