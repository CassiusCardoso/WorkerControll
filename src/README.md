# Projeto Worker Contracts

## Descrição

Este projeto em Java é uma aplicação simples para gerenciar dados de trabalhadores, seus contratos por hora e calcular a renda mensal com base nos contratos ativos naquele mês.

O programa recebe dados do usuário via console, cria objetos das classes `Worker`, `Departament` e `HourContract` e calcula a renda do trabalhador considerando o salário base e os contratos adicionados.

---

## Estrutura do Projeto

- **Main.java**: classe principal que controla o fluxo do programa (entrada, processamento e saída).
- **entities/**: pacote que contém as classes do domínio:
    - `Worker`: representa o trabalhador, com atributos como nome, nível, salário base, departamento e lista de contratos.
    - `Departament`: representa o departamento onde o trabalhador está alocado.
    - `HourContract`: representa um contrato por hora com data, valor por hora e duração.
    - `WorkerLevel`: enumeração que define os níveis do trabalhador (`JUNIOR`, `MID_LEVEL`, `SENIOR`).

---

## Funcionalidades

- Cadastro de um departamento.
- Cadastro de um trabalhador com:
    - Nome
    - Nível (JUNIOR, MID_LEVEL, SENIOR)
    - Salário base
    - Departamento
- Registro de múltiplos contratos por hora para o trabalhador, com:
    - Data
    - Valor por hora
    - Duração (horas)
- Cálculo da renda mensal do trabalhador, que soma o salário base com os valores de contratos ativos naquele mês.

---

## Conceitos Java utilizados

- **Orientação a Objetos**: uso de classes para representar entidades do domínio (Worker, Departament, HourContract).
- **Enumeração (enum)**: para representar o nível do trabalhador (`WorkerLevel`).
- **Coleções (`ArrayList`)**: para armazenar múltiplos contratos associados a um trabalhador.
- **Tratamento de exceções (`try-catch`)**: para tratar erros de parsing de datas.
- **Manipulação de datas (`SimpleDateFormat` e `Calendar`)**: para entrada e comparação de datas.
- **Entrada de dados via console (`Scanner`)**: para interação com o usuário.
- **Métodos getters e setters**: para encapsulamento dos atributos.
- **Métodos adicionais**:
    - `addContract()` e `removeContract()` para gerenciar contratos do trabalhador.
    - `income()` para calcular o total ganho em um mês específico.

---

## Como executar

1. Certifique-se de ter o JDK instalado (versão 8 ou superior).

2. Compile os arquivos `.java` (todos no pacote `entities` e o `Main.java`).

3. Execute a classe `Main`.

4. Siga as instruções no console para inserir:
    - Nome do departamento
    - Dados do trabalhador
    - Número e dados dos contratos
    - Mês e ano para cálculo da renda

---

## Exemplo de uso

```text
Enter departament's name: Sales
Enter worker data:
Name:
John Doe
Level (JUNIOR, MID_LEVEL, SENIOR):
SENIOR
Base salary:
4000.00
How many contracts to this worker:
2
Contract #1 data:
Date (DD/MM/YYYY):
15/05/2025
Value per hour:
50.00
Duration (hours):
20
Contract #2 data:
Date (DD/MM/YYYY):
23/05/2025
Value per hour:
30.00
Duration (hours):
10
-------- INCOME ----------
Enter month and year to calculate income (MM/YYYY):
05/2025
Name: John Doe
Departament: Sales
Income for: 05/2025: 5100.00
