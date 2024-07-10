package com.generation.games.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "O atributo título é obrigatório.")
	@Size(min = 3, max = 300, message = "O atributo título deve conter no mínimo 3 caracteres e no máximo 300 caracteres")
	private String titulo;
	
	@NotBlank (message = "O atributo texto é obrigatório.")
	@Size(min = 10, message = "O atributo descrição deve conter no mínimo 10 caracteres")
	private String descricao;
	
	@NotNull (message = "O atributo preço é obrigatório.")
	private float preco;
	
	@NotBlank (message = "O atributo idiomas é obrigatório.")
	@Size(min = 5, max = 100, message = "O atributo idiomas deve conter no mínimo 5 caracteres e no máximo 100 caracteres")
	private String idiomas;
	
	@NotBlank (message = "O atributo desenvolvedor é obrigatório.")
	@Size(max = 100, message = "O atributo desenvolvedor deve conter no máximo 100 caracteres")
	private String desenvolvedor;
	
	@NotBlank (message = "O atributo classificação indicativa é obrigatório.")
	@Size(min = 6, max = 40, message = "O atributo classificação indicativa deve conter no mínimo 6 caracteres e no máximo 40 caracteres")
	private String classificacaoIndicativa;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private CategoriaModel categorias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(String classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public CategoriaModel getCategorias() {
		return categorias;
	}

	public void setCategorias(CategoriaModel categorias) {
		this.categorias = categorias;
	}

	
}
