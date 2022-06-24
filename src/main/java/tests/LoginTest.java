package tests;

import org.testng.annotations.Test;
import classes.Login;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	
	String driverPath = "C:\\Academia SDET\\libs\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	public static final String correoTest = "logintestcase@gmail.com";
	public static final String passwordTest = "123456";
	
  @Test
  public void f() {
	  Login inicio = new Login(driver);
	  inicio.getLogin(correoTest, passwordTest);
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
  }

  @AfterClass
  public void afterClass() {
	  //driver.close();
  }

}
