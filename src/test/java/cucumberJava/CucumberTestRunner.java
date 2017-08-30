package cucumberJava;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
@CucumberOptions(plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"}, features = "src/test/resourses/features")


public class CucumberTestRunner extends AbstractTestNGCucumberTests {


}
