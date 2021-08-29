package pagefactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class ContactUs {
	WebDriver driver;
	@FindAll({
		@FindBy(how = How.NAME, using = "firstname"),
		@FindBy(how = How.NAME, using = "lastname"),
		@FindBy(how = How.NAME, using = "company"),
		@FindBy(how = How.NAME, using = "email"),
		@FindBy(how = How.NAME, using = "mobilephone"),
		@FindBy(how = How.NAME, using = "enquiry_details"),
	})
	
	private List<WebElement> allTexts;
	@FindBy(how=How.XPATH, 
			using ="//input[@type='checkbox']")
	 private  WebElement check;
	 public ContactUs( WebDriver driver) {
		 this.driver = driver;
       PageFactory.initElements(driver, this);
	 }
	 
	 public void fillDetails(String firstname, String lastname, String company, String countrycode, String email, String mobile, String enquiry) {
		 
		 allTexts.get(0).sendKeys(firstname);
		 allTexts.get(1).sendKeys(lastname);
		 allTexts.get(2).sendKeys(company);
		 allTexts.get(3).sendKeys(email);
		 allTexts.get(4).sendKeys(mobile);
		 allTexts.get(5).sendKeys(enquiry);
		 Select country=new Select(driver.findElement(By.name("country")));
		 country.selectByValue(countrycode);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement check = driver.findElement(By.xpath(".//input[@type='checkbox']"));
		 js.executeScript("arguments[0].click();", check);
	 }
	 
	 public void shot() {
		 Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
         try {
             ImageIO.write(screenshot.getImage(),"PNG",new File("img"));
         } catch (IOException e) {
             e.printStackTrace();
         }
	 }
	 
	 
}
