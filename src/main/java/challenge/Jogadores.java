package challenge;

import java.time.LocalDate;

public class Jogadores {
	
	private String nomeCompleto;
	private int idade;
	private String nacionalidade;
	private String nomeDosClubes;
	private Double rescisao;
	private LocalDate dataDeNascimento;
	private Double euroWage;

	public Jogadores(String nome, int idade, 
			String pais, String clube,
			Double rescisao, Double euroWage,
			LocalDate dataDeNascimento) {
		this.nomeCompleto = nome;
		this.idade = idade;
		this.nacionalidade = pais;
		this.nomeDosClubes = clube;
		this.rescisao = rescisao;
		this.dataDeNascimento = dataDeNascimento;
		this.euroWage = euroWage;
	}

	public Jogadores() {
		
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public int getIdade() {
		return idade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getNomeDosClubes() {
		return nomeDosClubes;
	}

	public Double getRescisao() {
		return rescisao;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public Double getEuroWage() {
		return euroWage;
	}

}
