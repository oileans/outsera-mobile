package steps;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.PaymentPage;

import java.util.List;
import java.util.Map;

public class PaymentSteps {
    private PaymentPage carrinho = new PaymentPage();


    @And("concluo o checkout")
    public void concluo_o_checkout(io.cucumber.datatable.DataTable dataTable) {

        Assert.assertTrue("Não foi possivel acessar a pagina de Pagamentos, verifique os logs", carrinho.conferirPedido());

        List<Map<String, String>> linhas = dataTable.asMaps();
        Map<String, String> payment = linhas.get(0);

        String NAME = payment.get("Nome");
        String CC = payment.get("Card Number");
        String ED = payment.get("Expiration Date");
        String CVV = payment.get("CVV");

        carrinho.preencherDadosPagamento(NAME, CC, ED, CVV);
        carrinho.clickConfirmOrder();

    }


}
