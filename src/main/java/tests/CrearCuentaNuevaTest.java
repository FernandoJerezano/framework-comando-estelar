package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classes.CrearCuenta;

public class CrearCuentaNuevaTest {
	
	String driverPath = "C:\\Academia SDET\\libs\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	
	private String correo = "fernando.jerezano123@gmai.com";
	private String contrasena = "Qwerty12";
	
	@Test 
	public void crearCuentaNueva() {
		
		driver.findElement(By.xpath("//a[@href='/']")).click();
		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@href='/login']"));
		linkLogin.click();
		
		WebElement linkSignUp = driver.findElement(By.xpath("//a[@href='/signup']"));
		linkSignUp.click();
		
		CrearCuenta crearCuenta = new CrearCuenta(driver);
		crearCuenta.ingresarDatosCuenta(correo, contrasena);	
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
}
