package steps;

import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @When("efetuo login com user {string} e {string}")
    public void efetuo_login_com_user_e(String user, String password) {
        loginPage.efetuaLogin(user, password);
    }
}
