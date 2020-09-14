# Spring Webflux Pokedex
Programação Reativa com Spring WebFlux Reactor e MongoDB

## Spring WebFlux
Criado para programar de forma reativa dentro do Spring.

### Aplicação java web com Spring MVC e síncrona, e bloqueante.
O Spring MVC processa as requisições uma a uma por ordem sequencial enquanto a primeira não terminar ele não começa a segunda.

### Spring WebFlux você trabalha de forma assíncrona e não bloqueante.
Recebendo varias requisições elas serão processadas paralelamente conforme elas vão chegando elas já vão sendo processadas e não bloqueá a aplicação.

### Principal biblioteca do Spring WebFlux e o REACTOR que utiliza operações.

MONO operações com 1 dado de retorno
fazendo um GET/id para retornar um usuário

FLUX operações com X dados de retorno
fazendo um Get para retornar todos os usuários

#### Utilizando o Spring boot junto ao Spring MVC traz o servidor Apache Tomcat embutido.
#### Utilizando o Spring boot junto ao Spring WEbFlux traz o Servidor NETTY embutido que opera em tempo de requisição assíncrona.

Utilizei o banco de dados MongoDB, pois, você tem que garantir que todo o fluxo seja reativo e não bloqueante.
Isso não acontece ao utilizar bancos relacionais, pois, eles não estão preparados para trabalhar de forma não bloqueante.
