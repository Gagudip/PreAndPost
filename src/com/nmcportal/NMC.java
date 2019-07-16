package com.nmcportal;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NMC {

	static String str = "";
	SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
	Date date = new Date();
	static String Parent = "";

	static WebDriver driver = null;

	public void DriverInitialize() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsingh\\Desktop\\Softwares\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://cne:cne@172.16.37.60/");

		driver.manage().window().maximize();

	}

	public void Request(String search) throws IOException {

		driver.findElement(By.xpath("//textarea[@id='questions']")).sendKeys(search);

		List ls = ExcelReader.ReadInputExcel();

		Iterator itr = ls.iterator();

		while (itr.hasNext()) {

			str = str + "\n" + itr.next();
		}

		driver.findElement(By.xpath("//textarea[@id='locations']")).sendKeys(str);

		Parent = driver.getWindowHandle();

		driver.findElement(By.id("submitButton")).click();

	}

	public void WriteExcel(int sheetnumber, String locator, int row, int column) throws Throwable {

		ExcelWriter ex = new ExcelWriter();

		int cell=0;
		int cell2=0;

		List<WebElement> ls = driver.findElements(By.xpath(
				"//table[@class='table table-bordered table-striped table-hover table-heading table-datatable dataTable']/thead/tr/th/label/input"));
		ex.IncreaseRow(sheetnumber);
		
		for (WebElement we : ls) {
			
		
	        System.out.println(we.getAttribute("value"));		
	
			ex.WriteWebTable(we.getAttribute("value"),cell);
			cell++;

		}

		ex.IncreaseRow(sheetnumber);
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {

				String value = driver.findElement(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover table-heading table-datatable dataTable']/tbody/tr["
								+ i + "]/td[" + j + "]"))
						.getText();
				
				
				ex.WriteWebTable(value,cell2);
				cell2++;

			}
			ex.IncreaseRow(sheetnumber);
			cell2=0;
		}

	}

	public void Takescreenshot(String Test) throws Throwable {

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

		newTab.remove(Parent);

		driver.switchTo().window(newTab.get(0));

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(formatter.format(date));

		FileUtils.copyFile(src, new File(
				"C:\\Users\\gsingh\\eclipse-workspace\\PreAndPostChecks\\" + Test + formatter.format(date) + ".png"));
	}
}
