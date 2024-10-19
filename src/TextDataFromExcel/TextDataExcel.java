package TextDataFromExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextDataExcel{
	public static void main(String args[]) throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testingbaba.com/old/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@class=\"close\"]")).click();
		driver.findElement(By.xpath("//*[@href=\"newdemo.html\"]")).click();
		driver.findElement(By.xpath("//*[@data-target=\"#elements\"]")).click();
		driver.findElement(By.xpath("//*[@href=\"#tab_2\"]")).click();
		
		WebElement iframe = driver.findElement(By.xpath("//*[@id=\"tab_2\"]/div/iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//*[@id=\"myCheck\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mylaptop\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mydesktop\"]")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@href=\"#tab_1\"]")).click();
		
		FileInputStream file = new FileInputStream("E:\\QA Testing\\Automation\\registdata\\sheet1.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("data1");
		int rowCount = sheet.getLastRowNum();
		
		XSSFRow currentRow = sheet.getRow(2);
		String fullname = currentRow.getCell(0).getStringCellValue();
		String email = currentRow.getCell(1).getStringCellValue();
		String currentAdd = currentRow.getCell(2).getStringCellValue();
		String permaAdd = currentRow.getCell(3).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@id=\"fullname1\"]")).sendKeys(fullname);
		driver.findElement(By.xpath("//*[@id=\"fullemail1\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"fulladdresh1\"]")).sendKeys(currentAdd);
		driver.findElement(By.xpath("//*[@id=\"paddresh1\"]")).sendKeys(permaAdd);
		driver.findElement(By.xpath("//*[@value=\"Submit\"]")).click();
		Thread.sleep(2000);
	}
}