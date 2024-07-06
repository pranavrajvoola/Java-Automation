package Pranavraj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AbstractComponents.AbstractComponents;

public class confirmationpage extends AbstractComponents {
	WebDriver driver;
	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="[class='hero-primary']")
	WebElement confirmationmessage;
	
	public String confirmationmessage() {
		return confirmationmessage.getText();
		
	}
	//String message=driver.findElement(By.cssSelector("[class='hero-primary']")).getText();

}
