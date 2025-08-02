package steps;

import io.cucumber.java.en.And;
import pages.CarrinhoPage;


public class CarrinhoSteps {

    private CarrinhoPage carrinho = new CarrinhoPage();

    @And("acesso o carrinho de compras")
    public void acesso_o_carrinho_de_compras() {
        carrinho.acessarMiniCart();
        carrinho.validaMinicart();
        carrinho.proceedCheckout();
    }

}
