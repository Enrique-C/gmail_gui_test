package runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features= "src/test/resources/features",
        glue= {"hook", "steps"})
public class RunCukesTest {

}
