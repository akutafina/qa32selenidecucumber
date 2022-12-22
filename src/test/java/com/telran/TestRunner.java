package com.telran;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
//        tags = "(@smoke or @ui) and (not @slow)",
        glue = {"com.telran.glue"},
        plugin = {"pretty","json:build/cucumber-report/cucumber.json"}
)

public class TestRunner {
}