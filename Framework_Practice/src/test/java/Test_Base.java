import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test_Base
{

	public WebDriver driver1;
	public ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("extent_report.html");
	public ExtentReports extent=new ExtentReports();
	public ExtentTest test=null;
	
}
