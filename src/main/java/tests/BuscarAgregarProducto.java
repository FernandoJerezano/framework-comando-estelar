package tests;

import org.testng.annotations.Test;

import classes.CarritoDeCompras;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BuscarAgregarProducto {

	String driverPath = "C:\\Academia SDET\\libs\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	String productos[] = {"ruby-on-rails-tote","ruby-on-rails-bag","ruby-on-rails-baseball-jersey","spree-bag","spree-tote"};
	
  @Test
  public void f() {
	  CarritoDeCompras buscarProducto = new CarritoDeCompras(driver);
	  driver.manage().window().maximize();
	  buscarProducto.buscarProducto("rails");
	  buscarProducto.seleccionarProducto(productos[0]);
	  buscarProducto.agregarProducto(0);
	  buscarProducto.goBack();
	  buscarProducto.goBack();
	  buscarProducto.goBack();
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
  }

  @AfterClass
  public void afterClass() {
  }

}
