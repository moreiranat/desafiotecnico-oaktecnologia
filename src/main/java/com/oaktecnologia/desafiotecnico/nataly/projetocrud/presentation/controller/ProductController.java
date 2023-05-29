package com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.ProductConverterService;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.business.service.ProductService;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.model.entity.Product;
import com.oaktecnologia.desafiotecnico.nataly.projetocrud.presentation.dto.ProductDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService service;

	private final ProductConverterService converterService;

	public ProductController(ProductService service, ProductConverterService converterService) {
		this.service = service;
		this.converterService = converterService;	
	}

	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody ProductDTO dto) {

		try {
            Product entity = converterService.dtoToProduct(dto);
            entity = service.save(entity);
            dto = converterService.productToDTO(entity);

            return new ResponseEntity(dto, HttpStatus.CREATED); //status 201 -> Created

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //status 400 -> Bad Request
        }
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody ProductDTO dto) {

		try {
			
            dto.setId(id);
            Product entity = converterService.dtoToProduct(dto);
            entity = service.update(entity);
            dto = converterService.productToDTO(entity);

            return ResponseEntity.ok(dto); //status 200 -> Ok

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //status 400 -> Bad Request
        }
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		
		return null;
	}

	@GetMapping
	public ResponseEntity find(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
			return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable("id") Long id) {

		return null;
	}

}
