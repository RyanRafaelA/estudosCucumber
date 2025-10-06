#language: pt
#encoding: UTF-8

Funcionalidade: Cadastro de Contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizado

Cenario: Deve inserir uma conta com sucesso
  Dado que estou acessando a aplicação
  Quando informo o usuário "seil@09"
  E a senha "seila098"
  E seleciono entrar
  Então visualizo a página inicial
  Quando seleciono Contas
  E seleciono Adicionar
  E informo a conta "Contas de Sei La"
  E seleciono Salvar
  Então a conta é inserida com sucesso

@rodar
Cenario: Não deve inserir uma conta sem nome
  Dado que estou acessando a aplicação
  Quando informo o usuário "seil@09"
  E a senha "seila098"
  E seleciono entrar
  Então visualizo a página inicial
  Quando seleciono Contas
  E seleciono Adicionar
  E seleciono Salvar
  Então sou notificado que o nome da conta é obrigatório

@rodar
Cenario: Não deve inserir uma conta com nome já existente
  Dado que estou acessando a aplicação
  Quando informo o usuário "seil@09"
  E a senha "seila098"
  E seleciono entrar
  Então visualizo a página inicial
  Quando seleciono Contas
  E seleciono Adicionar
  E informo a conta "Contas de Sei La"
  E seleciono Salvar
  Então sou notificado que já existe uma conta com esse nome