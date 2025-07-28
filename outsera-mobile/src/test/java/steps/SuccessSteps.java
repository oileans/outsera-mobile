package steps;

import io.cucumber.java.en.Then;
import pages.SuccessPage;

public class SuccessSteps {

    SuccessPage successPage = new SuccessPage();


    @Then("eu vejo a confirmação de pedido bem‑sucedido")
    public void eu_vejo_a_confirmação_de_pedido_bem_sucedido() {
        successPage.placeOrder();
        successPage.validarSuccessPage();
    }
}
