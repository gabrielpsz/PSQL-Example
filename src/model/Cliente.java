package model;

import java.util.Date;

public class Cliente {
	
	// Atributos
	private long idCliente;
	private String nome;
	private String email;
	private Date dataDeNascimento;
	
	public Cliente(String nome, String email, Date dataDeNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}



	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}



	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}



	public Cliente() {
		
	}
	
	// Getters and Setters
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
