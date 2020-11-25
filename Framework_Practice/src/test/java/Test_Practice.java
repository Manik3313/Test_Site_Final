import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.testproject.sdk.drivers.TestProjectCapabilityType;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;

public class Test_Practice extends Test_Base
{
	ChromeDriver driver ;
	public static final String USERNAME = "manikgupta5";
	public static final String AUTOMATE_KEY = "Bwqkktpz6zVucA9btguN";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	ChromeOptions  caps= new ChromeOptions();
	//ChromeDriver driver = new ChromeDriver(chromeOptions);
	@BeforeTest
	public void setup() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
	caps.setCapability("os", "Windows");
	caps.setCapability("os_version", "10");
	caps.setCapability("browser", "Chrome");
	caps.setCapability("browser_version", "80");
	caps.setCapability("name", "manikgupta5's First Test");
	caps.setCapability(
	        TestProjectCapabilityType.CLOUD_URL,URL);
	driver = new ChromeDriver("SmBwObq_TzSPkKuuWV8hQobhRwkX7f8tHKXXPZj4bYY1",caps);
	driver.get("https://github.com/Manik3313/Test_Site_Final/blob/main/Framework_Practice/pom.xml");
	}
	@BeforeMethod
	public void setup2()
	{
		driver.get("https://www.facebook.com/");
		System.out.println("Before test");
		
	}
	
	@DataProvider(name = "testdata2" )
	public Object[][] test_data2() throws IOException {
		excel_utls excel = new excel_utls("C:\\Users\\manik.gupta\\Documents\\test\\user_data2.xlsx",
				"Sheet3");
		Object[][] data = excel_utls.testData(excel);
		return data;
		
	}
	@Test(dataProvider = "testdata2")
	public void test1(Map<String, String> data)
	{
		System.out.println("In test1");
	
		driver.get("https://www.google.com/");
		System.out.println(data.get("name"));
		driver.report().test("Passed", true).submit();
		
		
	}
	@Test
	public void test2()
	{
		System.out.println("In test2");
		
		driver.get("https://www.facebook.com/");
		driver.report().test("fail", false).submit();
		Assert.assertTrue(false, "Fail");
		
	}
	@AfterTest
	public void tear_down()
	{
		System.out.println("In tear down");
		
		driver.quit();
	}

	}
