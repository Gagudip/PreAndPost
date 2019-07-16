package com.nmcportal;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;

public class Jovian {

		String satellite = "System_J";
		
		static int Counter= 1;
		
		
		public void EM7Alarms(String Url) {


		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(Url);

		driver.manage().window().maximize();

		driver.findElement(By.id("LOGIN_user")).sendKeys("gsingh");

		driver.findElement(By.id("LOGIN_pwd")).sendKeys("1qaz2wsx!@#$%");

		driver.findElement(By.id("submit")).click();

		driver.findElement(By.xpath("//*[@id='TB_closeWindowButton']")).click();

		WebElement sev = driver.findElement(By.name("eseverity"));

		Select severity = new Select(sev);

		severity.selectByIndex(4);

		driver.findElement(By.xpath("//*[@name='company']")).sendKeys("Jup");

		TakesScreenshot alarms = (TakesScreenshot) driver;

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(src, new File("C:\\Users\\gsingh\\eclipse-workspace\\PreAndPostChecks\\"+satellite+Counter+" alarm.png"));
			Counter++;
			driver.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}
}
