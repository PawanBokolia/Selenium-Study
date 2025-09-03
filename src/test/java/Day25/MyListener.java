package Day25;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{

	public void onStart(ITestContext context) {
	    System.out.println("test execution is started");
	  }
	  
	  
	 public void onTestStart(ITestResult result) {			//this method will execute before every test method this is different from onStart method
		   System.out.println("test started ");
		  }
	
	 
	 public void onTestSuccess(ITestResult result) {
		   System.out.println("test pass");
		  }
	 
	 
	public void onTestFailure(ITestResult result) {
	 System.out.println("test failed");
	  }

	 public void onTestSkipped(ITestResult result) {
		  System.out.println("test skiped");
		  }
	 
	 public void onFinish(ITestContext context) {
		   System.out.println("test execution is completed");
		  }
	
	
	
	
}
