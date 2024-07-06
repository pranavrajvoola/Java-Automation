package Pranavraj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AbstractComponents.AbstractComponents;

public class checkoutpage extends AbstractComponents {
	WebDriver driver;
	public checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".form-group")
	WebElement country;
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement selectcountry;
	@FindBy(css=".btnn")
	WebElement submit;
	By results=By.cssSelector(".ta-results");

	/*Actions a=new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector(".form-group")), "india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".btnn")).click();
*/
	public void selectcountry(String countryname) {
		Actions a=new Actions(driver);
		a.sendKeys(country,countryname).build().perform();
		waitforelementtoAppear(results);
		selectcountry.click();
		}
	public confirmationpage submitorder() {
		submit.click();
		return new confirmationpage(driver);
	}
		
	
		
	}

	


