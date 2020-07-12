package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

//Defining this class will be a Rest resource
@RestController
//Defines the path that this resource will respond to
@RequestMapping(value = "/categories")
public class CategoryResource {

	/*Pré processamento por baixo dos panos q resolve as dependencias. Ele vai obter automaticamente uma instancia do CategoryRepository*/
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	/*Notation vai reconhecer o caminho /1  e vai casar com o ID  "http://localhost:8080/categories" */
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}  

}