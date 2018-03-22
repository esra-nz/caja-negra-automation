package nz.esra.framework.steps.config;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.esra.framework.config.YamlConfiguration;


public class Configuration {

    private YamlConfiguration configuration;

    @Given("^The configuration path*$")
    public void the_configuration_path() throws Throwable {
        throw new PendingException();
    }

    @When("^the framework is initiated$")
    public void the_framework_is_initiated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^any code in the framework has access to the configuration setting$")
    public void any_code_in_the_framework_has_access_to_the_configuration_setting() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
