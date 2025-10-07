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

Esquema do Cenario: Deve validar cadastro contas
  Quando informo a conta "<conta>"
  E seleciono Salvar
  Então recebo a mensagem "<mensagem>"

  Exemplos:
    | conta            | mensagem                           |
    | Conta de Sei La  | Conta adicionada com sucesso!      |
    |                  | Informe o nome da conta            |
    | Conta mesmo nome | Já existe uma conta com esse nome! |