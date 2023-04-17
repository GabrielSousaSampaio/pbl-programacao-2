# Sistema de Controle de Assistência Técnica de Microcomputadores

Este é um sistema de controle de assistência técnica de microcomputadores, que é composto por várias classes e métodos para criar e gerenciar ordens de serviço, componentes, técnicos e clientes.
As funcionalidades deste sistema incluem a criação e manipulação de ordens de serviço, adição e remoção de serviços, atualização do status da ordem de serviço, obtenção de preços e custos de ordens de serviço, atualização da ordem de serviço e gerenciamento de estoque de peças e equipamentos.

## ⚙️ Principais funcionalidades requeridas

### 1. 😀 Criar e manipular clientes 
- O sistema deve permitir o cadastro de novos usuários, bem como a atualização destes cadastros. 
### 2. 🗂️ Criar e manipular ordens de serviço
- O sistema deve permitir que o técnico de assistência técnica crie e gerencie ordens de serviço  capazes de conter serviços de montagem, instalação e limpeza para cada cliente.
### 3. 🧩 Gerenciar o estoque de peças e equipamentos necessários para realizar os serviços
-  O sistema deve possibilitar que o técnico possa retirar do estoque as peças necessárias para realizar os serviços que lhe são atribuídos. Desta forma, uma vez que o estoque de peças pode acabar, o projeto também deve contar com recursos que permitem o gerenciamento do estoque, como adição de novas peças e controle de custos.
### 4. 🧾 Gerar faturas para os serviços prestados
- O sistema deve possibilitar a criação de fatura para determinado serviço concluído. Este também deve ter suporte para diversas formas de pagamento: cartão de crédito, transferência bancária ou dinheiro.
### 5. ✍️ Gerar relatórios sobre o desempenho do serviço
- O sistema deve possibilitar que relatórios acerca dos serviços possam ser gerados. Assim sendo, o projeto deve ser capaz de retornar o tempo de médio de espera, os serviços cancelados, os custos das peças utilizadas, o estoque e a satisfação média dos clientes.

## 📋 Padrão MVC

#### Este projeto utiliza do padrão MVC para separar a lógica de negócios da interface do usuário.
* O controller é responsável por gerenciar a interação entre o modelo e a visão, garantindo que as informações sejam atualizadas corretamente e validando as entradas do usuário
* Os models são representados pelas classes que gerenciam as ordens de serviço, componentes, técnicos e clientes, entre outros.
* A view é responsável pela interface do usuário, permitindo que o técnico de assistência técnica visualize as informações sobre as ordens de serviço, peças e estoque

<p align = center>Obs: A view ainda não se encontra disponível no projeto<p/>

## 📁 Padrão DAO

#### No sistema, o padrão DAO é utilizado para gerenciar as operações relacionadas ao armazenamento dos dados. As classes DAO (Data Access Object) fornecem métodos de acesso aos dados, como inserir, atualizar e excluir. Desta forma, o projeto obtém as seguintes vantagens:

* Facilidade na manutenção do sistema, já que as mudanças nas classes DAO não afetam diretamente as outras classes.
* Possibilidade de reutilização de código, já que as classes DAO podem ser utilizadas em diferentes partes do sistema.

## 🧑‍💻 Diagrama de classes

![Cópia de diagrama uml - diagrama de classe](https://user-images.githubusercontent.com/91295529/232501891-84d5c45f-04fe-4cfa-84d0-bb618ce7e78c.jpeg)

## 💻 Diagrama de casos de uso

![diagrama uml - casos de uso ideias](https://user-images.githubusercontent.com/91295529/232383345-f6e70d26-4c92-4661-bf11-eafe54ae5cf3.jpeg)

## 🛠️ Construído com

* Java - Openjdk versão 19.0.2
* Junit - Versão 5.8.1
* IntelliJ IDEA - 2022.3.2 (Community Edition)
* Git - Versão 2.39.1.windows.1

## ✒️ Autores

* **Gabriel Sampaio** - [@GabrielSousaSampaio](https://github.com/GabrielSousaSampaio)
* **Gabriel Baptista** - [@BaptistaGabriel](https://github.com/BaptistaGabriel)
