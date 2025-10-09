
# BDD Teste Unitarios

Esse repositório tem o objetivo integrar o JUnit a framework Cucumber.

## Sobre o Projeto
Este projeto contém exemplos práticos para aprender a utilizar o JUnit com Cucumber em Java, incluindo:
- Configuração inicial do Cucumber com Jaava
- Escrita de features em Gherkin
- Configuração do Runner do projeto
- Implementação de step em Java
- Implementação das classes de entidades: Filme, NotaAluguel, TipoAluguel
- Implementação da classe serviço: AluguelService
- Implementação da classe util: DateUtil

## Dependências
### Cucumber
- versão: 7.17.0
- [Documentação](https://cucumber.io/) 
```mvn
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.17.0</version>
    <scope>test</scope>
</dependency>
```
### Cucumber-junit
- versão: 7.17.0
- [Documentação](https://docs.junit.org/current/user-guide/) 
```mvn
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>7.17.0</version>
    <scope>test</scope>
</dependency>
```

