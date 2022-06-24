package tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classes.CrearCuenta;
import classes.RealizarCompra;

public class RealizarCompraConRegistroTest {
	
	//String driverPath = "C:\\Users\\fernando.jerezano\\eclipse-workspace\\libs\\chromedriver_win32\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	
	// datos para la información de dirección
	String firstName 		= "Fernando";
	String lastName 		= "Jerezano"; 
	String streetAddress 	= "1020 Mission St Suite H";
	String city 			= "South Pasadena"; 
	String countryId 		= "232"; 
	String stateId 			= "3529"; 
	String zip 				= "91030"; 
	String phone 			= "2291000001";
	
	// datos para el método de pago
	int shippingMethod = 1;
	
	// datos para información de la tarjeta 
	String nameOnCard 		= "Bogus Gateway";
	String cardNumber 		= "1";
	String expirationMonth	= "12";
	String expirationYear	= "28";
	String cvv				= "111";
	
	// datos para la cuenta
	String email 	= "fernando999@mail.com";
	String password = "Qwerty12";
	
	@Test
	public void realizaCompraConRegistro() {
		
		email = getUsername();
		
		anadirCarrito();
		
		RealizarCompra realizarCompraConRegistro = new RealizarCompra(driver);
		CrearCuenta crearCuenta = new CrearCuenta(driver);
		
		
		realizarCompraConRegistro.hacerCheckout();
		
		crearCuenta.ingresarDatosCuenta(email, password);
		
		realizarCompraConRegistro.ingresarDatosDireccion(firstName, lastName, streetAddress, city, countryId, stateId, zip, phone);
		realizarCompraConRegistro.ingresarDatosEntrega(shippingMethod);
		
		realizarCompraConRegistro.ingresarDatosPagoTarjeta(nameOnCard, cardNumber, expirationMonth, expirationYear, cvv);
		
		driver.findElement(By.name("commit")).click();
		
		driver.close();
	}
	
	
	public void anadirCarrito() {
		
		WebElement home = driver.findElement(By.xpath("//a[@href='/']"));
		home.click();
		
		WebElement producto = driver.findElement(By.xpath("//div[@id='product_1']"));
		producto.click();
		
		WebElement anadir = driver.findElement(By.id("add-to-cart-button"));
		anadir.click();
	}
	
	
	@BeforeClass
	public void beforeClass() {
		//System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
	}
	
	public String getUsername() {
		return "fernando"+System.currentTimeMillis()+"@mail.com";
	}

}
