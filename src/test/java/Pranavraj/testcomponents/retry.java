package Pranavraj.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

	int count=0;
	int countmax=1;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<countmax) {
			count++;
			return true;
		}
		
		
		return false;
	}

}
