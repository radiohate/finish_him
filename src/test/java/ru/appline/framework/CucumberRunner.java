package ru.appline.framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"ru/appline/framework/steps"},
        features = {"src/test/resources/"},
        tags = {"@firstTest"},
        strict = true
)
public class CucumberRunner {}
