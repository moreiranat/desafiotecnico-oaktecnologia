package com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.ProductService;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.repository.ProductRepository;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller.exceptions.ObjectAlreadyExistsException;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Product save(Product product) {
		
		if(product.getId() != null) {
			throw new IllegalStateException("Product is already in the database");
		}
		
		if(repository.existsByName(product.getName())) {
			throw new ObjectAlreadyExistsException("There is already a product with name " + product.getName());
		}
		
		return repository.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Product> find(Product filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
