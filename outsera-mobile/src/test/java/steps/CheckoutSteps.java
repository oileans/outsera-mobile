package steps;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.CheckoutPage;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {

    CheckoutPage checkout = new CheckoutPage();

    @And("preencho o formulário de checkout com:")
    public void preencho_o_formulário_de_checkout_com(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue("Não foi possivel acessar a pagina de Checkout, verifique os logs", checkout.validaPageCheckout());

        // Converte para lista de mapas (cada mapa = uma linha da tabela)
        List<Map<String, String>> linhas = dataTable.asMaps();
        Map<String, String> dados = linhas.get(0);

        String nome = dados.get("Nome");
        String addr1 = dados.get("Address1");
        String addr2 = dados.get("Address2");
        String cidade = dados.get("City");
        String estado = dados.get("State");
        String cep = dados.get("Zip Code");
        String pais = dados.get("Country");

        checkout.preencherFormulario(nome, addr1, addr2, cidade, estado, cep, pais);
        checkout.clicarToPayment();
    }
}
