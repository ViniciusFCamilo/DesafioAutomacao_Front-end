# language: pt

  Funcionalidade: Adicionar novo customer, buscar ele na grid e excluir ele do sistema
    Eu como usuario do sistema
    Quero adicionar um novo costumer
    Para buscar ele na grid e depois exclui-lo do sistema

  @teste
  Cenario: Adicionar um novo customer
    Dado que estou no site
    Quando eu seleciono “Bootstrap V4 Theme” no combobox
    E clico em Add Customer
    E preencho as informações do formulário
    E clico em Salvar
    Então eu vejo a mensagem de sucesso
    E fecho o navegador

  @teste
  Cenario: Excluir Customer
    Dado que estou no site
    Quando eu seleciono “Bootstrap V4 Theme” no combobox
    E clico em Add Customer
    E preencho as informações do formulário
    E clico em Salvar
    Então eu vejo a mensagem de sucesso
    Dado que visualizo o texto Go back to list dentro da mensagem de sucesso
    Quando clico no texto
    Então sou direcionado para a pagina principal
    E pesquiso o nome do customer que criei
    E deleto esse customer
    Então eu vejo a mensagem de cadastro deletado com sucesso
    E fecho o navegador





