package com.google.tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.google.pages.PasswordScreen;
import com.google.pages.LoginPage;

public class LoginTest {
	
	String driverPath = "D:\\test\\chromedriver.exe";
	WebDriver driver;
	PasswordScreen passwordScreen;
	LoginPage loginPage;
	
	@BeforeTest
	public void setup(){
    
		System.setProperty("webdriver.chrome.driver", driverPath);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/ServiceLogin");
        loginPage = new LoginPage(driver);
        passwordScreen = new PasswordScreen(driver);
        
    }
	
	@Test(priority =0)
	@Parameters({"username"})
	public void checkUsername(String userName) {
		try {
		loginPage.setEmailorPhone(userName);
		loginPage.clickNext();
		WebElement body = driver.findElement(By.tagName("body"));
		
		boolean check= body.getText().contains("Couldn't find your Google Account");
		System.out.println("check value "+check);
		Assert.assertEquals(false,check);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test(priority =1)
	@Parameters({"password"})
	public void checkPassword(String password) {
		
		try {
			Thread.sleep(1000);
		
		passwordScreen.setPassword(password);
		passwordScreen.clickNext();
		WebElement body = driver.findElement(By.tagName("body"));
		
		boolean check= body.getText().contains("Wrong password");
		System.out.println("check value "+check);
		Assert.assertEquals(false,check);
	}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	 public void release() {
		  driver.quit();
	  }

}
