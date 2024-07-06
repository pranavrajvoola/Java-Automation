package Pranavraj.stepDefinition;

import java.io.IOException; 
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Pranavraj.CartPage;
import Pranavraj.LandingPage;
import Pranavraj.Productscatlogue;
import Pranavraj.checkoutpage;
import Pranavraj.confirmationpage;
import Pranavraj.testcomponents.baseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinition extends baseTest {
	
	public LandingPage landingPage;
	public Productscatlogue Productscatalogue;
	public confirmationpage confirmationPage;
	public CartPage CartPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException, InterruptedException
	{
	   landingPage = launchingApplication();
	   Thread.sleep(1000);
		//code
	}

    
    
	@Given("^loggedin with username (.+) and password (.+)$")
	public void loggedin_with_username_and_password(String username, String password) {
	
		Productscatalogue = landingPage.SendingDetails(username, password);
    }
    @When("^I add product (.+) to cart$")
    public void i_add_product_zara_coat_to_cart(String productName) throws InterruptedException {
    	List<WebElement> products1 = Productscatalogue.productlist();
    	Productscatalogue.addToCart(productName);
        
    }
    @When("^checkout (.+) and submit the order$")
    public void checkout_zara_coat_and_submit_the_order(String productName) {
    	CartPage cartPage = Productscatalogue.gotoCart();

		Boolean match = cartPage.verifyingproducts(productName);
		Assert.assertTrue(match);
		checkoutpage checkoutPage = cartPage.gottocheckout();
		checkoutPage.selectcountry("india");
		confirmationPage = checkoutPage.submitorder();
    }
    @Then("{string} message is displayed on confirmation page")
    public void message_is_displayed_on_confirmation_page(String string) {
    	String confirmMessage = confirmationPage.confirmationmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
    }
 
    @When("^I add product (.+) to cart and verify the match$")
    public void I_add_product_to_cart_and_verify_the_match(String productName) throws InterruptedException {
    	List<WebElement> products1 = Productscatalogue.productlist();
    	Productscatalogue.addToCart(productName);
        CartPage CartPage=Productscatalogue.gotoCart();
    	
    	Boolean match=CartPage.verifyingproducts(productName);
    	Assert.assertFalse(match);
    	driver.close();
    	
    }
   
    
    
    @Then("^(.+)message is displayed$")
    public void something_message_is_displayed(String string) throws InterruptedException {
    	Assert.assertEquals(string, landingPage.Errormessage());
    	driver.close();
    	
    }

    
}
