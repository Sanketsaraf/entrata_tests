package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/FeatureFiles", glue = {"stepDefinitions"},
    plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)

public class Test {

}
