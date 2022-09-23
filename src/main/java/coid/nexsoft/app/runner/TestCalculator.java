package coid.nexsoft.app.runner;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coid.nexsoft.app.pageobject.Calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculator { 

	private static AndroidDriver<MobileElement> driver;
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21513");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");//automationName
//		capabilities.setCapability("automationName", "UiAutomator2");
//		capabilities.setCapability("appWaitDuration", "600");
//		capabilities.setCapability("adbExecTimeout", "600");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		System.out.println("DRIVER : "+driver);
	}
	
	@BeforeMethod
	public void pageObject() {
		calculator = new Calculator(driver);
	}
	
	@Test
	public void testAdd() {
		calculator.calcAdd();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "3");
		calculator.clear();
	}
	
	@Test
	public void testMul() {
		calculator.calcMul();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "1");
		calculator.clear();
	}
	
	@Test
	public void testdiv() {
		calculator.calcDiv();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "2");
		calculator.clear();
	}
	
	@Test
	public void testEq() {
		calculator.calcEq();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "8");
		calculator.clear();
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}	
}