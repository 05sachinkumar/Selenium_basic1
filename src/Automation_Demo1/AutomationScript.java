package Automation_Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScript {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testingbaba.com/old/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@class=\"close\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@data-target=\"#elements\"]")).click();
		driver.findElement(By.xpath("//*[@href=\"#tab_2\"]")).click();
		
		WebElement iframe = driver.findElement(By.xpath("//*[@id=\"tab_2\"]/div/iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//*[@id=\"myCheck\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mylaptop\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"mydesktop\"]")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@href=\"#tab_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"fullname1\"]")).sendKeys("sachin kumar");
		driver.findElement(By.xpath("//*[@id=\"fullemail1\"]")).sendKeys("sachin@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"fulladdresh1\"]")).sendKeys("sanjay colony,sec-23,fbd");
		driver.findElement(By.xpath("//*[@id=\"paddresh1\"]")).sendKeys("faridabad,haryana");
		driver.findElement(By.xpath("//*[@value=\"Submit\"]")).click();
	}
}
