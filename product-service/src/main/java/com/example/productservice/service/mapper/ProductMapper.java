package com.example.productservice.service.mapper;

import com.example.productservice.controller.dto.response.ProductDTO;
import com.example.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", source = "product.id")
    ProductDTO mapToDTO(Product product);
}
