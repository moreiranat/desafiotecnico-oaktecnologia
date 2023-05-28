package com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.ProductConverterService;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.dto.ProductDTO;

@Service
public class ProductConverterServiceImpl implements ProductConverterService {

	@Override
	public Product dtoToProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO productToDTO(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> productToDTOList(List<Product> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> dtoToProductList(List<ProductDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
