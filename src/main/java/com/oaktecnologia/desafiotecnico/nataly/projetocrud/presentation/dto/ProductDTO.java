package com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.dto;

import java.math.BigDecimal;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;

public class ProductDTO {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private BigDecimal value;
	
	private Boolean availableForSale = false;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.value = product.getValue();
		this.availableForSale = product.getAvailableForSale();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Boolean getAvailableForSale() {
		return availableForSale;
	}

	public void setAvailableForSale(Boolean availableForSale) {
		this.availableForSale = availableForSale;
	}
	
}
