package com.generation.games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.games.model.ProdutoModel;
import com.generation.games.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		@GetMapping
		public ResponseEntity<List<ProdutoModel>> getAll(){
			return ResponseEntity.ok(produtoRepository.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<ProdutoModel> getById(@PathVariable Long id){
			return produtoRepository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<ProdutoModel>> getByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(produtoRepository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		@PostMapping
		public ResponseEntity<ProdutoModel> post(@Valid @RequestBody ProdutoModel produtos){
			if (produtoRepository.existsById(produtos.getCategorias().getId()))
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(produtoRepository.save(produtos));
				
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
		}
		
		@PutMapping
		public ResponseEntity<ProdutoModel> put(@Valid @RequestBody ProdutoModel produtos){
			if (produtoRepository.existsById(produtos.getId())){
				
				if (produtoRepository.existsById(produtos.getCategorias().getId()))
					return ResponseEntity.status(HttpStatus.OK)
							.body(produtoRepository.save(produtos));
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
				
			}			
				
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			Optional<ProdutoModel> produtos = produtoRepository.findById(id);
			
			if(produtos.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
			produtoRepository.deleteById(id);				
		}
		
	}
