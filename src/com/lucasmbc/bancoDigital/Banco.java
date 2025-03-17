package com.lucasmbc.bancoDigital;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.contas = new ArrayList<>();
		this.nome = nome;		
	}

	public String getNome() {
		return nome;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
}
