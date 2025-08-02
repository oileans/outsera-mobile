Feature: Checkout de compras no aplicativo móvel

  Scenario: Adicionar um item ao carrinho e finalizar a compra
    Given que acesso o app de compras
    And adiciono o produto "Sauce Labs Backpack" ao carrinho
    And acesso o carrinho de compras
    When efetuo login com user "bob@example.com" e "10203040"
    And preencho o formulário de checkout com:
      | Nome     | Address1  | Address2 | City    | State     | Zip Code | Country | Card Number         | Expiration Date | CVV |
      | Willians | Rua Laura | Rua Enio | Barueri | Sao Paulo | 06415130 | Brasil  | 5464 3134 5498 5131 | 12/31           | 333 |
    And concluo o checkout
      | Nome     | Card Number         | Expiration Date | CVV |
      | Willians | 5464 3134 5498 5131 | 12/31           | 333 |
    Then eu vejo a confirmação de pedido bem‑sucedido