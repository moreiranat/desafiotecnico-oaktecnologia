package com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;
	
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String name;
	
	@Column(name = "PRODUCT_DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "PRODUCT_VALUE", nullable = false)
	private BigDecimal value;
	
	@Column(name = "PRODUCT_AVAILABLEFORSALE", nullable = false)
	private Boolean availableForSale = false;

}
