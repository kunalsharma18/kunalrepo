package com.google.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PasswordScreen {
	
	WebDriver driver;
	
	
	public PasswordScreen(WebDriver driver) {
          this.driver = driver;
          PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = ".//*[text()='Next']")
	WebElement nextButton;
	
	
	public void setPassword(String passkey) {
		password.sendKeys(passkey);
	}
	
	public void clickNext() {
		nextButton.click();
	}
	

}
