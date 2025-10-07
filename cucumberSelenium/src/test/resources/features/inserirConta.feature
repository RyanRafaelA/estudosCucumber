#language: pt
#encoding: UTF-8

Funcionalidade: Cadastro de Contas
  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizado

Contexto:
  Dado que estou acessando a aplicação
  Quando informo o usuário "seil@09"
  E a senha "seila098"
  E seleciono entrar
  Então visualizo a página inicial
  Quando seleciono Contas
  E seleciono Adicionar

Cenario: Deve inserir uma conta com sucesso
  E informo a conta "Contas de Sei La"
  E seleciono Salvar
  Então a conta é inserida com sucesso

Cenario: Não deve inserir uma conta sem nome
  E seleciono Salvar
  Então sou notificado que o nome da conta é obrigatório

Cenario: Não deve inserir uma conta com nome já existente
  E informo a conta "Conta mesmo nome"
  E seleciono Salvar
  Então sou notificado que já existe uma conta com esse nome