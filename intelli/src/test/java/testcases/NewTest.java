package testcases;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagefactory.ContactUs;
import pagefactory.LandingPage;
public class NewTest {
	
	String driverPath = "D:\\test\\chromedriver.exe";
	WebDriver driver;
	LandingPage landingpage;
	ContactUs contactus;
	
	@BeforeTest

    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // Dimension d = new Dimension(480,620);
        //Resize the current window to the given dimension
       // driver.manage().window().setSize(d);

        driver.get("https://www.intelligencebank.com/");
        

    }
	
	
	
	
  @Test (priority=0)
  
  public void f() {
	  landingpage=new LandingPage(driver);
	  landingpage.clickLogin();
	  
  }
  
  @Test(priority = 1)
  @Parameters({"firstname", "lastname","company","countrycode","email","mobile","enquiry"})
  public void f1(String firstname, String lastname, String company, String countrycode, String email, String mobile, String enquiry) {
	  contactus=new ContactUs(driver);
	  
	  contactus.fillDetails(firstname, lastname, company, countrycode, email, mobile, enquiry);
	  
		contactus.shot();
	
	}
	  
  @AfterTest
  
  public void release() {
	  driver.quit();
  }
  
}
