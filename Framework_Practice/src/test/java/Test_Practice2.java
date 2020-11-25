import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
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

public class Test_Practice2 {


	boolean flag=false;
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
		driver.get("https://the-internet.herokuapp.com/");
	}
	@Test
	@DataProvider(name = "testdata" )
	public Object[][] test_data() throws IOException {
		excel_utls excel = new excel_utls("C:\\Users\\manik.gupta\\Documents\\test\\user_data.xlsx",
				"Sheet1");
		Object[][] data = excel_utls.testData(excel);

		return data;
	}

	@Test
	@DataProvider(name = "testdata2" )
	public Object[][] test_data2() throws IOException {
		excel_utls excel = new excel_utls("C:\\Users\\manik.gupta\\Documents\\test\\user_data.xlsx",
				"Sheet2");
		Object[][] data = excel_utls.testData(excel);
		return data;
		
	}

	@Test
	@DataProvider(name = "testdata3" )
	public Object[][] test_data3() throws IOException {
		excel_utls excel = new excel_utls("C:\\Users\\manik.gupta\\Documents\\test\\user_data1.xlsx",
				"Sheet3");
		Object[][] data = excel_utls.testData(excel);

		return data;
	}

	@Test(/*testName = "search_in_datatable" ,*/ dataProvider ="testdata2")
	public void test_1(Map<String, String> data)
	{
		driver.findElement(By.xpath("//a[contains(text(),'Sortable Data Tables')]")).click();
		String lastname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[contains(text(),"+"'"+data.get("lastname")+"'"+")]/../td[2]")).getText();
				//"//table[@id='table1']/tbody/tr/td[contains(text(),'Smith')]/../td[4]")).getText();
		//driver.get("https://the-internet.herokuapp.com/");
		if(lastname.equalsIgnoreCase(data.get("firstname")))
		{
			driver.report().test("Data found", true).submit();
			AssertJUnit.assertTrue(true);
		}
		else
		{
			driver.report().test("Data not found", false).submit();
			driver.report().step("Fail", false, true);
			//driver.report().step("Fail", false, true);
			AssertJUnit.assertTrue(false);
		}
	}
	
	@Test(/*testName = "login_page",*/ dataProvider = "testdata")
	public void test_2(Map<String, String> data)
	{
		System.out.println(data.get("username"));
		System.out.println("password");
		driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.get("password"));
		driver.findElement(By.xpath("//button")).click();
		flag=false;
		if (driver.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/secure"))
		{
			driver.report().test("User Login successfully123", true).submit();;
			flag=true;
		}
		else 
			//driver.report().test("Unable to login123", false).submit();;
			driver.report().step("Fail", false, true);
			
		//driver.get("https://the-internet.herokuapp.com/");	
		AssertJUnit.assertTrue(flag);
	}
	
	@Test(/*testName = "Multi_Window_Test"*/)
	public void test_3()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		if (driver.getWindowHandles().size()>1) 
		{
			driver.report().test("Operation Successful", true).submit();;
			AssertJUnit.assertTrue(true);
		}
			else
			{
				driver.report().test("Operation unsuccessful", false).submit();;
				driver.report().step("Fail", false, true);
				AssertJUnit.assertTrue(false);
			}
			
	}
	@Test(/*testName="Dynamic_Control"*/)
	public void test_4()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Controls')]")).click();
		//driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
		/*
		 * if
		 * (driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled())
		 * Assert.assertTrue(true); else Assert.assertTrue(false);
		 */driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
		if(driver.findElement(By.xpath("//*[@id='checkbox']")).isDisplayed())
		{
			driver.report().test("Dynamic control work", true).submit();;
			AssertJUnit.assertTrue(true);
		}
		else
		{

			//driver.report().test("Dynamic control donot work", false).submit();;
			driver.report().step("Fail", false, true);
			
			AssertJUnit.assertTrue(false);
		}
	}
	@Test(/*testName = "Forgot_Password",*/dataProvider = "testdata3")
	public void test_5(Map<String, String> data)
	{
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password')]")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(data.get("email"));
		driver.findElement(By.xpath("//*[@id='form_submit']/i")).click();
		String msg=driver.findElement(By.xpath("//*[@id='content']")).getText();
		if (msg.equalsIgnoreCase("Your e-mail's been sent!"))
		{
			driver.report().test("forgot passsword work", true).submit();;
			
			AssertJUnit.assertTrue(true);
		}
			
		else
		{

			//driver.report().test("forgot password donopt work", false).submit();
			driver.report().step("Fail", false, true);
			
			AssertJUnit.assertTrue(false);	
		}
			
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}



