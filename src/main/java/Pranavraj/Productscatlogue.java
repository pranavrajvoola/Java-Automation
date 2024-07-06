package Pranavraj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pranavraj.AbstractComponents.AbstractComponents;

public class Productscatlogue extends AbstractComponents {
	WebDriver driver;

	public Productscatlogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By tostmessage=By.cssSelector("#toast-container");
	
	//@FindBy(xpath="//ul/li[4]/button[@class='btn btn-custom']")
	//WebElement click;
	
	
	
	public List<WebElement> productlist() {
		waitforelementtoAppear(productsBy);
		return products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod = productlist().stream().filter(product->

    	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addToCart(String productName) throws InterruptedException {
		WebElement prod= getProductByName(productName);
		prod.findElement(addToCart).click();
		waitforelementtoAppear(tostmessage);
		waitforelementtoDissappear(spinner);
		
		
		
		
	}
	
	}
	

