package pagefactory;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LandingPage {
	 WebDriver driver;
	 @FindBy(how= How.LINK_TEXT, using="CONTACT US")
	 WebElement contactUs; 
	 
	 public LandingPage( WebDriver driver) {
		 this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	 }
	 //Click on contactUS

	    public void clickLogin(){

	            contactUs.click();

	    }  

}
