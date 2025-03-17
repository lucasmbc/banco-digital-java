package com.lucasmbc.bancoDigital;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente, Banco banco) {
		super(cliente, banco);		
	}

	@Override
	protected void imprimirInfosComuns() {
		System.out.println("=== Extrato conta Poupança ===");
		super.imprimirInfosComuns();
	}
	
	@Override
	public String toString() {
		return String.format("Conta Poupança %s { %s }", banco.getNome(), super.toString());
	}

}
