package com.lucasmbc.bancoDigital;

public class Main {

	public static void main(String[] args) {
		Cliente lucas = new Cliente();
		lucas.setNome("Lucas");
		
		Banco b1 = new Banco("Bradesco");
		
		Conta cc = new ContaCorrente(lucas, b1);
		Conta poupanca = new ContaPoupanca(lucas, b1);
		
		System.out.println(b1.getContas());
		
		cc.depositar(100);
		cc.transferir(100, poupanca);
		cc.depositar(150);
		cc.transferir(50, poupanca);
		
		cc.imprimirInfosComuns();
		poupanca.imprimirInfosComuns();		

	}

}
