package com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.ProductConverterService;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.dto.ProductDTO;

@Service
public class ProductConverterServiceImpl implements ProductConverterService {

	private static final String MESSAGE = "Could not convert, because object is null";

	@Override
	public Product dtoToProduct(ProductDTO dto) {
		
		if (dto != null) {
            Product entity = new Product();

            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setValue(dto.getValue());
            entity.setAvailableForSale(dto.getAvailableForSale());

            return entity;
        }
		
        throw new IllegalArgumentException(MESSAGE);
	}

	@Override
	public ProductDTO productToDTO(Product entity) {
		
		if (entity != null) {
            ProductDTO dto = new ProductDTO();

            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setValue(entity.getValue());
            dto.setAvailableForSale(entity.getAvailableForSale());

            return dto;
        }
		
        throw new IllegalArgumentException(MESSAGE);
	}

	@Override
	public List<ProductDTO> productToDTOList(List<Product> entities) {
		
		if(entities != null) {
            List<ProductDTO> dtos = new ArrayList<>();

            if(!entities.isEmpty()) {
                for (Product product: entities) {
                    ProductDTO dto = productToDTO(product);
                    dtos.add(dto);
                }
            }

            return dtos;
        }
		
        throw new IllegalArgumentException(MESSAGE);
	}

	@Override
	public List<Product> dtoToProductList(List<ProductDTO> dtos) {
		
		if(dtos != null) {
            List<Product> entities = new ArrayList<>();

            if(!dtos.isEmpty()) {
                for (ProductDTO dto : dtos) {
                   Product entity = dtoToProduct(dto);
                    entities.add(entity);
                }
            }

            return entities;
        }
		
        throw new IllegalArgumentException(MESSAGE);
    }

}
