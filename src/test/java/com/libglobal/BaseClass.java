package com.libglobal;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String url) {
		driver = new ChromeDriver();
		driver.get(url);
	}

	public static void browserMax() {
		driver.manage().window().maximize();
	}

	public static WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	public static WebElement findElementByClassname(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	public static WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public static void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static String getTheText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String getaTtribute(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}

	public static void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static void dragDrop(WebElement source, WebElement Dest) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, Dest).perform();
	}

	public static void doubleClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public static void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public static void screenshot(String filePath) throws Exception {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(filePath);
		FileUtils.copyFile(s, d);
	}

	public static void browserClose() {
		driver.close();
	}

}