package Pranavraj.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pranavraj.CartPage;
import Pranavraj.ordersPage;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement ordersHeader;
	@FindBy(css=".fa.fa-sign-out")
	WebElement signout;
	
		public ordersPage gotoOrders() {
			
			ordersHeader.click();
			ordersPage ordersPage=new ordersPage(driver);
			return ordersPage;
			
		
	}
		public CartPage gotoCart() {
			//driver.findElement(By.xpath("//ul/li[4]/button[@class='btn btn-custom']")).click();
			cartHeader.click();
			CartPage CartPage=new CartPage(driver);
			return CartPage;
			
			
		}
		public void Signout() {
			signout.click();
			
			
		}

	public void waitforelementtoAppear(By FindBy) {
		

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitforWebelementtoDissappear() throws InterruptedException {
		Thread.sleep(1000);

		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

		//wait.until(ExpectedConditions.invisibilityOf(element));
		}
	public void waitforelementtoDissappear(WebElement element) throws InterruptedException {
		Thread.sleep(1000);

		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

		//wait.until(ExpectedConditions.invisibilityOf(element));
		}
	
	
	

}
