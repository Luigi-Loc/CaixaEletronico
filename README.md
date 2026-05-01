# 💰 Caixa Eletrônico em Java

Este projeto implementa um sistema simples de **Caixa Eletrônico (ATM)** em Java, capaz de gerenciar cédulas, realizar saques e controlar o saldo disponível.

## 📌 Funcionalidades

* ✔️ Reposição de cédulas (R$2, R$5, R$10, R$20, R$50, R$100)
* ✔️ Consulta do total disponível no caixa
* ✔️ Relatório de cédulas disponíveis
* ✔️ Definição de cota mínima do caixa
* ✔️ Realização de saques com cálculo automático das notas

---

## 🧠 Lógica do Sistema

O sistema utiliza uma abordagem simples:

* Armazena a quantidade de cada cédula
* Calcula o valor total disponível
* Para saque:

  * Prioriza notas de maior valor (R$100 → R$2)
  * Usa divisão inteira para determinar quantas notas podem ser usadas
  * Atualiza o estoque após o saque

---

## 🏗️ Estrutura do Código

### Classe Principal

`CaixaEletronico`

### Atributos

```java
private int n2, n5, n10, n20, n50, n100;
private int cotaMinima;
```

---

## ⚙️ Métodos Principais

### 🔹 `reposicaoCedulas(Integer cedula, Integer quantidade)`

Adiciona cédulas ao caixa.

### 🔹 `pegaValorTotalDisponivel()`

Retorna o valor total disponível.

### 🔹 `pegaRelatorioCedulas()`

Mostra a quantidade de cada cédula.

### 🔹 `armazenaCotaMinima(Integer minimo)`

Define o valor mínimo do caixa antes de alertar operador.

### 🔹 `sacar(Integer valor)`

Realiza o saque, respeitando:

* disponibilidade de notas
* valor mínimo do caixa

---

## 🚨 Regras de Negócio

* ❌ Não permite saque com valor ≤ 0
* ❌ Não permite saque sem notas suficientes
* ❌ Não permite saque se atingir a cota mínima
* ❌ Não aceita reposição com quantidade inválida

---

## 🖥️ Interface Gráfica

O sistema possui integração com uma interface gráfica:

```java
GUI janela = new GUI(CaixaEletronico.class);
janela.show();
```

⚠️ A classe `GUI` não está incluída no projeto.

---

## ▶️ Como Executar

1. Compile o projeto:

```bash
javac CaixaEletronico.java
```

2. Execute:

```bash
java CaixaEletronico
```

---

## 📌 Exemplo de Uso

```java
CaixaEletronico caixa = new CaixaEletronico();

caixa.reposicaoCedulas(100, 10);
caixa.reposicaoCedulas(50, 5);

System.out.println(caixa.pegaValorTotalDisponivel());

System.out.println(caixa.sacar(150));
