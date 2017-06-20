package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa {
	
	private long id;
	private String nome;
	private String cpf;
	private Date dataDeNascimento;
	private ArrayList<Carro> carros;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String cpf, Date dataDeNascimento, Carro carro) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.carros = new ArrayList<>();
		this.carros.add(carro);
		System.out.println("Tamanho carros -> " +this.carros.size());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public ArrayList<Carro> getCarros() {
		return carros;
	}
	
}
