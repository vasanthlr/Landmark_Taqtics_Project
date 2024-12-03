package com.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.libglobal.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@Before
	public void test1() {
		browserLaunch("https://landmark.taqtics.co/");
		browserMax();
	}

	@After
	public void test2(Scenario scenario) throws InterruptedException {

		if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] s = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(s, "img/png", "LandmarkTaqtics failed scenario....");
		}

		driver.quit();
	}

}
