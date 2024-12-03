package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumberreport.CucumberReport;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources" 
,snippets= SnippetType.CAMELCASE
,glue="com.stepdefinition"
,monochrome = true
,plugin = {"pretty", "json:target\\cucumber-reports\\Cucumber.json"}
,tags = "@swagger or @landmark"
)
public class TestRunner {
	
	@AfterClass
	public static void generateCucumberReport() {
		CucumberReport.generateReport("target\\cucumber-reports\\Cucumber.json");
	}

}
