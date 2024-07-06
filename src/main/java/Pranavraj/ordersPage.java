package Pranavraj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AbstractComponents.AbstractComponents;

public class ordersPage extends AbstractComponents {
	WebDriver driver;

	public ordersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> Ordersnames;
	
	/*List<WebElement> cartproduct= driver.findElements(By.cssSelector("tr td:nth-child(3)"));
	boolean match=cartproduct.stream().anyMatch(s->s.getText().contains(productName));*/
	public boolean verifyingproductsnames(String productName) {
		boolean match=Ordersnames.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
}
