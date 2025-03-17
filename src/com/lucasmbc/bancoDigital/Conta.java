package com.lucasmbc.bancoDigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected Banco banco;
	protected List<Operacao> historicoSaque;
	protected List<Operacao> historicoDeposito;

	public Conta(Cliente cliente, Banco banco) {
		historicoSaque = new ArrayList<>();
		historicoDeposito = new ArrayList<>();
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
		this.banco.getContas().add(this);
	}

	public void sacar(double valor) {
		saldo -= valor;
		historicoSaque.add(new Operacao(valor, LocalDateTime.now()));
	}

	public void depositar(double valor) {
		saldo += valor;
		historicoDeposito.add(new Operacao(valor, LocalDateTime.now()));
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s \n", this.cliente.getNome());
		System.out.printf("Agencia: %d \n", this.agencia);
		System.out.printf("Numero: %d \n", this.numero);
		System.out.printf("Saldo: %.2f \n", this.saldo);
		
		System.out.println("SAQUES");
		if (!historicoSaque.isEmpty()) {
			for(Operacao operacao : historicoSaque) {
				System.out.println(operacao);
			}
		} else {
			System.out.println("Nenhum saque realizado.");
		}
		
		System.out.println("DEPÓSITOS");
		if (!historicoDeposito.isEmpty()) {
			for(Operacao operacao : historicoDeposito) {
				System.out.println(operacao);
			}
		} else {
			System.out.println("Nenhum depósito realizado");
		}
	}

	@Override
	public String toString() {
		return String.format("[agencia=%d, numero=%d, saldo=%.2f, titular=%s]", agencia, numero, saldo,
				cliente.getNome());
	}

	protected class Operacao {
		private double valor;
		private LocalDateTime data;

		public Operacao(double valor, LocalDateTime data) {
			this.valor = valor;
			this.data = data;
		}

		public double getValor() {
			return valor;
		}

		public LocalDateTime getData() {
			return data;
		}

		@Override
		public String toString() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			return String.format("Valor: %.2f, Data: %s", valor, data.format(formatter));
		}
	}

}
