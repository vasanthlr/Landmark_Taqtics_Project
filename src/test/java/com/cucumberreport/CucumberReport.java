package com.cucumberreport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReport {
	
	public static void generateReport(String jsonFilePath) {

		File reportOutputDir = new File("target\\cucumber-reports\\JVM_Report");
		
		Configuration configuration = new Configuration(reportOutputDir, "Cucumber JVM Report");
		
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS", "Windows");
		configuration.addClassifications("Sprint", "24");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFilePath);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
		
		
	}

}
