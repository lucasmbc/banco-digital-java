# Sistema Bancário em Java

Este repositório é a solução para o desafio de projeto: Criando um Banco Digital com Java e Orientação a Objetos, do Bootcamp Bradesco - Java Cloud Native da [DIO](https://www.dio.me/), que consiste em criar um sistema bancário simples, que permite a criação de contas correntes e poupanças, realização de depósitos, saques e transferências, além de registrar o histórico de operações com data e hora.

## Funcionalidades

- Criação de clientes, contas correntes e contas poupança.

- Realização de depósitos, saques e transferências entre contas.

- Registro do histórico de operações (saques e depósitos) com data e hora.

- Exibição de informações das contas, incluindo saldo e histórico de operações.

## Diagrama de Classes

Abaixo está o diagrama de classes do sistema:

```mermaid
classDiagram
    class Cliente {
        -String nome
        +String getNome()
        +void setNome(String nome)
    }

    class Banco {
        -String nome
        -List~Conta~ contas
        +Banco(String nome)
        +String getNome()
        +List~Conta~ getContas()
        +String toString()
    }

    class Conta {
        -int agencia
        -int numero
        -double saldo
        -Cliente cliente
        -Banco banco
        -List~Operacao~ historicoSaque
        -List~Operacao~ historicoDeposito
        +Conta(Cliente cliente, Banco banco)
        +void sacar(double valor)
        +void depositar(double valor)
        +void transferir(double valor, Conta contaDestino)
        +void imprimirInfosComuns()
        +class Operacao
            -double valor
            -LocalDateTime data
            +Operacao(double valor, LocalDateTime data)
            +String toString()        
    }

    class ContaCorrente {
        +ContaCorrente(Cliente cliente, Banco banco)
        +void imprimirInfosComuns()
    }

    class ContaPoupanca {
        +ContaPoupanca(Cliente cliente, Banco banco)
        +void imprimirInfosComuns()
    }

    Cliente "1" --* "1" Conta : Pertence a
    Banco "1" --* "0..*" Conta : Contém
    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca
```

## Como Executar
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/sistema-bancario-java.git
```
2. Navegue até o diretório do projeto:
```bash
cd sistema-bancario-java
```
3. Compile e execute o código:
```bash
javac Main.java
java Main
```