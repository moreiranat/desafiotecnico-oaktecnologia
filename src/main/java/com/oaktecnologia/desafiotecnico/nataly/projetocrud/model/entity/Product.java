package com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableForSale, description, id, name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(availableForSale, other.availableForSale)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", value=" + value
				+ ", availableForSale=" + availableForSale + "]";
	}

}
