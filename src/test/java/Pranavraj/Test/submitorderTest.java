package Pranavraj.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pranavraj.CartPage;
import Pranavraj.Productscatlogue;
import Pranavraj.checkoutpage;
import Pranavraj.confirmationpage;
import Pranavraj.ordersPage;
import Pranavraj.testcomponents.baseTest;


public class submitorderTest extends baseTest {
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
    	
   
    	Productscatlogue Productscatlogue=landingPage.SendingDetails(input.get("email"), input.get("password"));
    	
    	
    	List<WebElement>products1=Productscatlogue.productlist();
    	Productscatlogue.addToCart(input.get("product"));
    	CartPage CartPage=Productscatlogue.gotoCart();
    	
    	boolean match=CartPage.verifyingproducts(input.get("product"));
    	Assert.assertTrue(match);
    	checkoutpage checkoutpage=CartPage.gottocheckout();
    	checkoutpage.selectcountry("india");
    	confirmationpage confirmationpage=checkoutpage.submitorder();
    	
    	String confirmmessage=confirmationpage.confirmationmessage();
    	Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    	confirmationpage.Signout();
    
    
    }
	@Test(dependsOnMethods= {"submitorder"})//it is not working
	
	public void OrderTest(){
		
		
	
		Productscatlogue productCatalogue = landingPage.SendingDetails("pranavrajvoola@gmail.com", "Vtu@12344");
	
		ordersPage ordersPage = productCatalogue.gotoOrders();
		Assert.assertTrue(ordersPage.verifyingproductsnames(productName));
	}
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "pranavrajvoola@gmail.com");
//		map.put("password", "Vtu@12344");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "pranavrajvoola@gmail.com");
//		map1.put("password", "Vtu@12344");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String,String>> data=getJsonDataToMap("C:\\Users\\HOME\\OneDrive\\Desktop\\selenium\\SeleniumFrameWork2\\src\\test\\java\\Pranavraj\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}

//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"pranavrajvoola@gmail.com", "Vtu@12344","ZARA COAT 3"},{"pranavrajvoola@gmail.com", "Vtu@12344","ADIDAS ORIGINAL"}};
//		
//	}
}
