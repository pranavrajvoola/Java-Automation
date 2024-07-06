package Pranavraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement email=driver.findElement(By.id("userEmail")); instead of writting like this we use page object factory method
	@FindBy(css="#userEmail")
	WebElement email1;
	
	@FindBy(id="userPassword")
	WebElement password1;
	
	@FindBy(id="login")
	WebElement submit;
	//.ng-tns-c4-1.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;

	public Productscatlogue SendingDetails(String email,String password)  {
		
		email1.sendKeys(email);
		password1.sendKeys(password);
		submit.click();
		Productscatlogue productscatlogue = new Productscatlogue(driver);
		return productscatlogue;
		
	
}
	public String Errormessage() throws InterruptedException {
		waitforWebelementtoDissappear();
		return errormessage.getText();
		
	}
	public void Url() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}

	
}
