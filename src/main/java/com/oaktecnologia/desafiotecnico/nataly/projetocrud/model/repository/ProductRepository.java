package com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public boolean existsByName(String name);
	
	public Optional<Product> findByName(String name);

}
