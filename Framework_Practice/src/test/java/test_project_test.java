import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.testproject.sdk.drivers.TestProjectCapabilityType;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
public class test_project_test 
{
	InputStream inputStream;
	 
	Properties prop = new Properties();
	//String propFileName = "config.properties";

    
	
	
	boolean flag=false;
	ChromeDriver driver ;
	ChromeOptions  caps= new ChromeOptions();
	//ChromeDriver driver = new ChromeDriver(chromeOptions);
	@BeforeTest
	public void setup() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException
	{
		InputStream input = new FileInputStream("C:\\Users\\manik.gupta\\git\\Test_Site_Final\\Framework_Practice\\src\\main\\java\\resource\\config.properties"); 
		prop.load(input);
		System.out.println(prop.get("key"));
		System.out.println(System.getProperty("user.dir"));
		
	}
	@Test
	public void login()
	{
		
	}
	
	
}
