package com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.dto.ProductDTO;

@Service
public interface ProductConverterService {
	
	public Product dtoToProduct(ProductDTO dto);
	
    public ProductDTO productToDTO(Product entity);
    
    public List<ProductDTO> productToDTOList(List<Product> entities);
    
    List<Product> dtoToProductList(List<ProductDTO> dtos);

}
