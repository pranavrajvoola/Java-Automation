package Pranavraj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;
	/*List<WebElement> cartproduct= driver.findElements(By.cssSelector("[class*='cartWrap']"));
	boolean match=cartproduct.stream().anyMatch(s->s.getText().contains(productName));*/
	public boolean verifyingproducts(String productName) {
		boolean match=productTitles.stream().anyMatch(s->s.getText().contains(productName));
		return match;
	}
	public checkoutpage gottocheckout() {
		//driver.findElement(By.xpath("//ul/li[3]/button[@type='button']")).click();
		checkout.click();
		return new checkoutpage(driver);
	}
	
}
