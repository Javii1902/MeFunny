package com.mefunny;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/login.feature",
glue = "com.revature.gluecode")
public class CucumberTestRunner {

}
