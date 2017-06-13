package view;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import control.ControleCliente;

public class TelaCliente {
	
	private ControleCliente ctrl;
	private Scanner sc;
	
	public TelaCliente(ControleCliente owner) {
		this.ctrl = owner;
		this.sc = new Scanner(System.in);
	}
	
	public void inicia() {
		System.out.println("Olá...");
		System.out.println("Escolha uma opcao: ");
		System.out.println(" 1) Cadastrar cliente.");
		System.out.println(" 2) Alterar cliente.");
		System.out.println(" 3) Excluir cliente.");
		System.out.println(" 4) Listar clientes.");
		System.out.println(" 5) Pesquisar cliente.");
		int opcao = sc.nextInt();
		switch (opcao) {
			case 1:
				cadastra();
				inicia();
				break;
			case 2:
				altera();
				inicia();
				break;
			case 3:
				exclui();
				inicia();
				break;
			case 4:
				lista();
				inicia();
				break;
			case 5:
				pesquisa();
				inicia();
				break;
			default:
				System.out.println("Opcao invalida");
				inicia();
				break;
		}
		
	}
	
	private void pesquisa() {
		System.out.println("Escolha uma opcao: ");
		System.out.println(" 1) Pesquisar por nome. ");
		System.out.println(" 2) Pesquisar por ID. ");
		int opcao = sc.nextInt();
		switch(opcao) {
			case 1:
				pesquisaPorNome();
				inicia();
				break;
			case 2:
				pesquisaPorId();
				inicia();
				break;
			default:
				System.out.println("Não encontrado");
				inicia();
				break;
		}
	}

	private void pesquisaPorId() {
		// TODO Auto-generated method stub
		long id = 0;
		do {
			System.out.println("Digite um ID para pesquisa: ");
			id = sc.nextLong();
		} while(id < 0);
		System.out.println(ctrl.pesquisaPorId(id));
	}

	void pesquisaPorNome() {
		// TODO Auto-generated method stub
		String nome = "";
		do {
			System.out.println("Digite seu nome: ");
			sc.nextLine();
			nome = sc.nextLine();
		} while(nome.trim().length() == 0);
		System.out.println(ctrl.pesquisaPorNome(nome));
	}

	private void lista() {
		System.out.println(ctrl.lista());
		inicia();
	}

	private void exclui() {
		int id = 0;
		do {
			System.out.println("Digite o ID do cliente que deseja excluir: ");
			id = sc.nextInt();
		} while(id < 0);
		ctrl.excluir(id);
	}

	private void altera() {
		System.out.println("Escolha uma opcao: ");
		System.out.println(" 1) Alterar nome.");
		System.out.println(" 2) Alterar email.");
		int opcao = sc.nextInt();
		switch(opcao) {
			case 1:
				alterarNome();
				inicia();
				break;
			case 2:
				alterarEmail();
				inicia();
				break;
			default:
				System.out.println("Não encontrado.");
				inicia();
				break;
		}
	}

	private void alterarEmail() {
		long id = 0;
		String email = "";
		do {
			System.out.println("Digite seu id: ");
			id = sc.nextLong();
			sc.nextLine();
			System.out.println("Digite seu novo email: ");
			email = sc.nextLine();
		} while(email.trim().length() == 0);
		
		ctrl.updateEmail(id, email);
	}

	private void alterarNome() {
		long id = 0;
		String nome = "";
		do {
			System.out.println("Digite seu id: ");
			id = sc.nextLong();
			sc.nextLine();
			System.out.println("Digite seu novo nome: ");
			nome = sc.nextLine();
		} while(nome.trim().length() == 0);
		
		ctrl.updateNome(id, nome);
	}

	private void cadastra() {
		String nome;
		String email;
		String data;
		sc.nextLine();
		do {
			System.out.println("Digite seu nome: ");
			nome = sc.nextLine();
		}while(nome.trim().length() == 0);
		
		do {
			System.out.println("Digite seu email: ");
			email = sc.next();
		}while(nome.trim().length() == 0);
		
		do {
			System.out.println("Digite sua data de nascimento(dd/MM/aaaa): ");
			data = sc.next();
		}while(nome.trim().length() == 0);
		
		ctrl.salvar(nome, email, data);
	}
	
}
