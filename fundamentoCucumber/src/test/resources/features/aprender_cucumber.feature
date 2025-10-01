#language: pt

Funcionalidade: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar critérios de aceitação

Cenario: Deve executar especificação
  Dado que criei o arquivo corretamente
  Quando executá-lo
  Então o especificação deve finalizar com sucesso

Cenario: Deve incrementar contador
  Dado que o valor do contador é 15
  Quando eu incrementar em 3
  Então o valor do contador ser 18

Cenario: Deve calcular atraso no prazo de entrega
  Dado que o prazo é dia "05/04/2018"
  Quando a entrega atrasar em 2 dias
  Então a entrega será efetuada em "07/04/2018"

Cenario: Deve calcular atraso no prazo de entrega da China
  Dado que o prazo é dia "05/04/2018"
  Quando a entrega atrasar em 2 meses
  Então a entrega será efetuada em "05/06/2018"