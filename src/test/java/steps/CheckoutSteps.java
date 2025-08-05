package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.CheckoutPage;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {

    CheckoutPage checkout = new CheckoutPage();

    @And("preencho o formulário de checkout com:")
    public void preencho_o_formulário_de_checkout_com(DataTable table) {
        List<Map<String, String>> dados = table.asMaps(String.class, String.class);
        Map<String, String> linha = dados.get(0);

        String nome = linha.get("Nome");
        String addr1 = linha.get("Address1");
        String addr2 = linha.get("Address2");
        String cidade = linha.get("City");
        String estado = linha.get("State");
        String cep = linha.get("Zip Code");
        String pais = linha.get("Country");

        checkout.preencherFormulario(nome, addr1, addr2, cidade, estado, cep, pais);
        checkout.clicarToPayment();
    }
}
