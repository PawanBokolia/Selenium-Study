package Day25;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;   //UI of the report 
	public ExtentReports extent;				//populate common info on the report 
	public ExtentTest test; 					//create test case entries in the report and update status of the test methods
	
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myreport.html");
		
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("functional testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("computer Name" , "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Pawan");
		extent.setSystemInfo("os", "window10");
		extent.setSystemInfo("Browser Name ", "chrome");
	  }
	
	public void onTestSuccess(ITestResult result) 
	{
	    
		test = extent.createTest(result.getName());  								//create a new entry in the report 
		test.log(Status.PASS, "test case Passed is: "+result.getName());			//update status pass/fail/skipped
	}
	
	 public void onTestFailure(ITestResult result) 
	 {
		 test = extent.createTest(result.getName()); 
		 test.log(Status.FAIL,"Test case Failed is: "+result.getName());
		 test.log(Status.FAIL,"Test case failed cause is: "+result.getThrowable());
     }
	
	  public void onTestSkipped(ITestResult result) 
	  {
		 test = extent.createTest(result.getName());
		 test.log(Status.SKIP, "Test case Skipped is : "+result.getName());
	
	  }

	  public void onFinish(ITestContext context)
	  {
		    extent.flush();
	  }


}