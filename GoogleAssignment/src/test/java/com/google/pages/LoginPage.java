package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = ".//input[@type='email']")
	WebElement userId;
	
	@FindBy(xpath = ".//*[text()='Next']")
	WebElement nextButton;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void setEmailorPhone(String userName) {
		userId.sendKeys(userName);
	}
	
	public void clickNext() {
		nextButton.click();
	}
	

}
