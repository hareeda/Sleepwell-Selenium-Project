package com.ust.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.ust.base.Settings;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    public static WebDriver driver;

    @Before
    public void setupdriver() {
    	String browser= "chrome";
        driver = Settings.setDriver(browser);
    }

    @After
    public void teardown(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }
}
