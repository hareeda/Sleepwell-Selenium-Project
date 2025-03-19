package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:Features", 
				glue = {"com.ust.stepdefinitions" }, 
				plugin = { "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread", "html:Reports/cucumber-reports/index.html" }
)


public class CucumberRunner extends AbstractTestNGCucumberTests {
}
