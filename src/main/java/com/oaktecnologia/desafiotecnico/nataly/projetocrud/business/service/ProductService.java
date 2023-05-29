package com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;

@Service
public interface ProductService {
	
	public Product save(Product product);
	
    public Product update(Product product);
    
    public void delete(Long id);
    
    public void deleteById(Long id); //deleta o Product passando o id dele
    
    public Page<Product> find(Product filter, Pageable pageable);
    
    public Optional<Product> findById(Long id);

}
