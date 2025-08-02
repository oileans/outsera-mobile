package support;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // encerra a sessão ao fim de cada cenário
        DriverFactory.quitDriver();
    }

}
