package Pranavraj.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pranavraj.CartPage;
import Pranavraj.Productscatlogue;
import Pranavraj.checkoutpage;
import Pranavraj.confirmationpage;
import Pranavraj.testcomponents.baseTest;

public class ErrorValidationLoginTest extends baseTest {
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Pranavraj.testcomponents.retry.class)
	public void loginErrorValidation() throws InterruptedException {
		
		
		landingPage.SendingDetails("pranavrajvla@gmail.com", "Vtu@12344");
		Assert.assertEquals("Incorrect email r password.", landingPage.Errormessage());
		
    	
	}
	@Test
	public void productErrorValidation() throws IOException, InterruptedException {
    	
		String productName = "ZARA COAT 3";  
    	Productscatlogue Productscatlogue=landingPage.SendingDetails("pranavrajvoola@gmail.com", "Vtu@12344");
    	
    	
    	List<WebElement>products1=Productscatlogue.productlist();
    	Productscatlogue.addToCart(productName);
    	CartPage CartPage=Productscatlogue.gotoCart();
    	
    	Boolean match=CartPage.verifyingproducts("ZARA COAT 33");
    	Assert.assertFalse(match);
    	
	

}
}
