package Pranavraj.testcomponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pranavraj.LandingPage;

public class baseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver intilizingDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\HOME\\OneDrive\\Desktop\\selenium\\SeleniumFrameWork2\\src\\main\\java\\Pranavraj\\resources\\Gobal.properties");
		prop.load(file);
		String browsername= System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");//! is not equals to 
		//String browsername=prop.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if(browsername.contains("Headless")) {
				options.addArguments("Headless");
			}
		
		 driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440,990));

    	
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();

	    	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	driver.manage().window().maximize();
		return driver;

	}
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//reading json to string
	
		
		String jsonContent=FileUtils.readFileToString(new File(filePath),
		StandardCharsets.UTF_8);
		
		//string to hashmap jackson databind
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){	
		});
		return data;
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File file=new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchingApplication() throws IOException {
		driver=intilizingDriver();
		 landingPage= new LandingPage(driver);
		landingPage.Url();
		
		return landingPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void quit() {
		
		driver.quit();
	}
}
