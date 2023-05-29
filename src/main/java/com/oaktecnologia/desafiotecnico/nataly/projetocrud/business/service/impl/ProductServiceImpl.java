package com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.ProductService;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.repository.ProductRepository;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller.exceptions.MissingFieldException;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller.exceptions.ObjectAlreadyExistsException;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller.exceptions.ObjectNotFoundException;

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
	@Transactional
	public Product update(Product product) {
		
		if(product.getId() == null) {
            throw new MissingFieldException("id", "update");
        } else if(!repository.existsById(product.getId())) {
            throw new ObjectNotFoundException("product", "id", product.getId());
        }

        if(repository.existsByName(product.getName())) {
            Product productSaved = findByName(product.getName()).get();
            if (!Objects.equals(productSaved.getId(), product.getId())) {
                throw new ObjectAlreadyExistsException("There is already a Product with name " + product.getName());
            }
        }

        return repository.save(product);
	}

	@Override
	@Transactional
	public void delete(Product product) {
		
		if(product.getId() == null) {
            throw new MissingFieldException("id", "delete");
        } else if(!repository.existsById(product.getId())) {
            throw new ObjectNotFoundException("product", "id", product.getId());
        }

        repository.delete(product);
		
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		
		if(id == null) {
            throw new MissingFieldException("id", "delete");
        } else if(!repository.existsById(id)) {
            throw new ObjectNotFoundException("product", "id", id);
        }

        repository.deleteById(id);
		
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
	
	private Optional<Product> findByName(String name) {
        if(name == null || name.isBlank()) {
            throw new MissingFieldException("name");
        }

        if (!repository.existsByName(name)) {
            throw new ObjectNotFoundException("product", "name", name);
        }

        return repository.findByName(name);
    }

}
