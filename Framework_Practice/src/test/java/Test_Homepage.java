/*
 * import static org.testng.Assert.assertTrue; import java.io.IOException;
 * import java.net.URL; import java.util.Map; import
 * java.util.concurrent.TimeUnit; import org.openqa.selenium.By; import
 * org.openqa.selenium.chrome.ChromeOptions; //import
 * org.openqa.selenium.chrome.ChromeDriver; import org.testng.Assert; import
 * org.testng.annotations.AfterTest; import org.testng.annotations.BeforeTest;
 * import org.testng.annotations.DataProvider; import
 * org.testng.annotations.Test; import com.aventstack.extentreports.Status;
 * import io.github.bonigarcia.wdm.WebDriverManager; import io.testproject.*;
 * import io.testproject.sdk.DriverBuilder; import
 * io.testproject.sdk.drivers.web.ChromeDriver; import
 * io.testproject.sdk.internal.exceptions.AgentConnectException; import
 * io.testproject.sdk.internal.exceptions.InvalidTokenException; import
 * io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
 * 
 * public class Test_Homepage extends Test_Base {
 * 
 * // ChromeDriver driver;//=new ChromeDriver();
 * 
 * @BeforeTest public void set_up() throws InvalidTokenException,
 * AgentConnectException, IOException, ObsoleteVersionException {
 * 
 * driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
 * .withRemoteAddress(new URL("http://localhost:8585"))
 * .withToken("SmBwObq_TzSPkKuuWV8hQobhRwkX7f8tHKXXPZj4bYY1").build(ChromeDriver
 * .class);
 * 
 * // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * 
 * // WebDr // WebDriverManager.chromedriver().setup();
 * 
 * // driver=new ChromeDriver();// You ahve to specify token here
 * driver.get("https://www.seleniumeasy.com/test/");
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
 * extent.attachReporter(htmlreporter);
 * 
 * if
 * (driver.findElement(By.xpath("//*[@id='at-cv-lightbox-close']")).isDisplayed(
 * )) {
 * 
 * driver.findElement(By.xpath("//*[@id='at-cv-lightbox-close']")).click(); }
 * 
 * }
 * 
 * @DataProvider(name = "testdata") public Object[][] test_data() throws
 * IOException { excel_utls excel = new excel_utls(
 * "C:\\Users\\manik.gupta\\eclipse-workspace\\Framework_Practice\\src\\test\\java\\sample_add.xlsx",
 * "Sheet1"); Object[][] data = excel_utls.testData(excel); return data; }
 * 
 * @Test(dataProvider = "testdata") public void add(Map<String, String> mapdata)
 * {
 * 
 * test = extent.createTest("Form_fill"); //
 * System.out.println(mapdata.get("a").); // int a
 * =Integer.parseInt(mapdata.get("a")); // int b
 * =Integer.parseInt(mapdata.get("b"));
 * driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")
 * ).click();
 * 
 * driver.findElement(By.xpath(
 * "//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a")).click();
 * driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(mapdata.get("a"));
 * driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(mapdata.get("b"));
 * test.log(Status.INFO, "Value entered"); //
 * System.out.println(Double.parseDouble(mapdata.get("b"))); double a =
 * Double.parseDouble(mapdata.get("a")); double b =
 * Double.parseDouble(mapdata.get("b"));
 * driver.findElement(By.xpath("//*[@id='gettotal']/button")).click(); int sum =
 * (int) (a + b);
 * 
 * String exp =
 * driver.findElement(By.xpath("//*[@id='displayvalue']")).getText();
 * System.out.println(exp);
 * System.out.println(String.valueOf(sum).equalsIgnoreCase(exp)); boolean f =
 * false; if (String.valueOf(sum).equalsIgnoreCase(exp)) { f = true;
 * System.out.println("In true"); test.log(Status.INFO, "Matches"); }
 * Assert.assertTrue(f);
 * 
 * 
 * // Double a = (Double) // System.out.println(mapdata.get("a")); // Double
 * b=(Double) mapdata.get("b"); // String.valueOf(a); //
 * driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")
 * ).click(); //
 * driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(String.valueOf(a));
 * //
 * driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(String.valueOf(b));
 * 
 * //Integer.valueOf(mapdata.get(key))
 * 
 * int a =(Integer) mapdata.get("a"); int b=(Integer) mapdata.get("b"); String
 * sa=String.valueOf(a); String sb=String.valueOf(b);
 * 
 * driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")
 * ).click(); driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(sa);
 * driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(sb);
 * driver.findElement(By.xpath("//*[@id='gettotal']/button")).click(); int
 * sum=a+b; String actual=String.valueOf(sum); String
 * exp=driver.findElement(By.xpath("//*[@id='displayvalue']")).getAttribute(
 * "value"); Assert.assertTrue(actual.equalsIgnoreCase(exp)); }
 * 
 * @Test(enabled = false) public void date_picker() { test =
 * extent.createTest("date_picker");
 * driver.findElement(By.xpath("//a[contains(text(),'Date pickers')]")).click();
 * boolean f = driver .findElement(By.
 * xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Date Picker')]"
 * )) .isDisplayed(); assertTrue(f); test.log(Status.FAIL,
 * "Clicked on Date picker"); driver.findElement(By.
 * xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap Date Picker')]"
 * )) .click(); f = driver.getCurrentUrl().equals(
 * "https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
 * assertTrue(f); test.log(Status.INFO, "Entered in date picker");
 * driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input")).
 * sendKeys("10/07/2020");
 * 
 * }
 * 
 * @Test(enabled = false) public void table_check() { //
 * *[@id="navbar-brand-centered"]/ul[1]/li[3]/a //
 * *[@id="navbar-brand-centered"]/ul[1]/li[3]/ul/li[1]/a test =
 * extent.createTest("Table cHeck");
 * driver.findElement(By.xpath("//a[contains(text(),'Table')]/b")).click();
 * boolean f =
 * driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]")).
 * isDisplayed(); assertTrue(f); test.log(Status.INFO, "Click on table");
 * 
 * driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]")).
 * click(); f = driver.getCurrentUrl().equals(
 * "https://www.seleniumeasy.com/test/table-pagination-demo.html");
 * assertTrue(f); test.log(Status.FAIL, "Move to table page"); while
 * (driver.findElement(By.xpath("//a[@class='next_link']")).isDisplayed()) {
 * System.out.println("In Loop"); int i =
 * driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'13')]")).
 * size(); System.out.println(
 * driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'13')]")).
 * getAttribute("value")); if (i > 0)//
 * driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'15')]")).
 * isDisplayed()) { System.out.println("Element Found"); break; } else
 * System.out.println("In else");
 * driver.findElement(By.xpath("//a[@class='next_link']")).click();
 * 
 * } }
 * 
 * @AfterTest public void teardown() { extent.flush(); driver.close();
 * driver.quit(); } }
 */