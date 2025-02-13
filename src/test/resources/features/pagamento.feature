# language: pt
Funcionalidade: Pagamento API

  Cenário: Criação de uma ordem de pagamento
    Dado que eu tenho os dados de uma nova ordem de pagamento
    Quando eu envio uma requisição para criar ordem de pagamento
    Então a ordem de pagamento deve ser criada com sucesso status 200

  Cenário: Buscar ordem de pagamento existente
    Dado que eu busco uma ordem de pagamento existente
    Quando eu envio uma requisição para buscar ordem de pagamento existente
    Então o pagamento deve ser retornado sucesso com status 200