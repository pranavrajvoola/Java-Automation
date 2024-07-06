package Pranavraj.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pranavraj.LandingPage;


public class standalonetest {
    public static void main( String[] args ) throws InterruptedException 
    {

    	String productName = "ZARA COAT 3";

    	

    	WebDriver driver = new ChromeDriver();

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	driver.manage().window().maximize();

    	

    	LandingPage landingPage = new LandingPage(driver);//object of that page

    	driver.get("https://rahulshettyacademy.com/client");
    	 driver.findElement(By.id("userEmail")).sendKeys("pranavrajvoola@gmail.com");

    	driver.findElement(By.id("userPassword")).sendKeys("Vtu@12344");

    	driver.findElement(By.id("login")).click(); 
    	//instead of writting this we use pom by parametrized constructor and created a object and calling the methods*/

    	
    	
   
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

    	
    	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    	    WebElement prod = products.stream().filter(product->

    	product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);
    	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
    	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));//something is coming in the screen so wait
    	
    	driver.findElement(By.xpath("//ul/li[4]/button[@class='btn btn-custom']")).click();
    	
    	List<WebElement> cartproduct= driver.findElements(By.cssSelector("[class*='cartWrap']"));
    	boolean match=cartproduct.stream().anyMatch(s->s.getText().contains(productName));
    	Assert.assertTrue(match); 
    	driver.findElement(By.xpath("//ul/li[3]/button[@type='button']")).click();
    	
    	Actions a=new Actions(driver);
    	a.sendKeys(driver.findElement(By.cssSelector(".form-group")), "india").build().perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
    	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
    	
    	
    	driver.findElement(By.cssSelector(".btnn")).click();
    	String message=driver.findElement(By.cssSelector("[class='hero-primary']")).getText();
    	Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
    	
    	driver.quit();
    }
}
