package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classes.CrearCuenta;

public class CrearCuentaNuevaTest {
	
	String driverPath = "C:\\Users\\fernando.jerezano\\eclipse-workspace\\libs\\chromedriver_win32\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	
	private String correo, contrasena;
	
	@Test 
	public void crearCuentaNueva() {
		correo = "fernando.jerezano123@gmai.com";
		contrasena = "Qwerty12";
		
		driver.findElement(By.xpath("//a[@href='/']")).click();
		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@href='/login']"));
		linkLogin.click();
		
		WebElement signUp = driver.findElement(By.xpath("//a[@href='/signup']"));
		signUp.click();
		
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
