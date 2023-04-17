# Sistema de Controle de Assistência Técnica de Microcomputadores

Este é um sistema de controle de assistência técnica de microcomputadores, que é composto por várias classes e métodos para criar e gerenciar ordens de serviço, componentes, técnicos e clientes.
As funcionalidades deste sistema incluem a criação e manipulação de ordens de serviço, adição e remoção de serviços, atualização do status da ordem de serviço, obtenção de preços e custos de ordens de serviço e edifícios, atualização da ordem de serviço e gerenciamento de estoque de peças e equipamentos.

## ⚙️ Principais funcionalidades requeridas

* ### Criar e manipular ordens de serviço
* ### Gerenciar o estoque de peças e equipamentos necessários para realizar os serviços
* ### Gerar faturas para os serviços prestados
* ### Gerar relatórios sobre o desempenho do serviço


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

## 💻 Diagrama de casos de uso

![diagrama uml - casos de uso ideias](https://user-images.githubusercontent.com/91295529/232383345-f6e70d26-4c92-4661-bf11-eafe54ae5cf3.jpeg)

## 🛠️ Construído com

* OpenJDK 19
* Maven
* IntelliJ IDEA
* Git

## ✒️ Autores

* **Gabriel Sampaio** -[@GabrielSousaSampaio](https://github.com/GabrielSousaSampaio)
* **Gabriel Baptista** - [@BaptistaGabriel](https://github.com/BaptistaGabriel)
