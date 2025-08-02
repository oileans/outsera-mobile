package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CarrinhoPage;
import pages.ProductsPage;

public class ProductSteps {
    private ProductsPage product = new ProductsPage();
    private CarrinhoPage carrinho = new CarrinhoPage();

    @Given("que acesso o app de compras")
    public void que_acesso_o_app_de_compras() {
        // inicialização do driver já acontece no Hook
        Assert.assertTrue("Não foi possivel acessar a pagina de produtos, verifique os logs", product.validaProduct());
    }

    @And("adiciono o produto {string} ao carrinho")
    public void adiciono_o_produto_ao_carrinho(String nomeProduto) {
        product.selecionaProdutoPorNome(nomeProduto);
        carrinho.addToCart();
    }


}
