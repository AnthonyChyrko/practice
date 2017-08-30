package cucumberJava;

        import calculator.Calculator;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.Assert;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
public class StepDefinitionForPow {
    private Calculator calc;

    double a;
    double b;
    double result;

    @Given("^two numbers like (\\d) and (\\d)")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        this.calc = new Calculator();
    }

    @When("^we try to find pow of our numbers")
    public void when() {
        result = calc.pow(a, b);
    }

    @Then("^result should be a (\\d)")
    public void then(double res) {
        Assert.assertEquals(res, result, 0.0001);
    }


}
