package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = ("src/test/java/feature"),
        glue = {"hook","testCase"},
        tags=   "",
        plugin = {"pretty",
                "html:target/cucumber-report/report.html",
                "json:target/cucumber-report/report.json",
                "junit:target/cucumber-report/report.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})



public class TestRunner{

        }