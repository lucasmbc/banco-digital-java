package com.lucasmbc.bancoDigital;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente, Banco banco) {
		super(cliente, banco);		
	}

	@Override
	protected void imprimirInfosComuns() {
		System.out.println("=== Extrato conta Corrente ===");
		super.imprimirInfosComuns();		
	}

	@Override
	public String toString() {
		return String.format("Conta Corrente %s { %s }", banco.getNome(), super.toString());
	}		

}
