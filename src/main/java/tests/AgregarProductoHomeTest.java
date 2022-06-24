package tests;

import org.testng.annotations.Test;

import classes.CarritoDeCompras;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AgregarProductoHomeTest {
	//String driverPath = "C:\\Academia SDET\\libs\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	String productos[] = {"ruby-on-rails-tote","ruby-on-rails-bag","ruby-on-rails-baseball-jersey","spree-bag","spree-tote"};
	
  @Test
  public void f() {
	  CarritoDeCompras agregarHome = new CarritoDeCompras(driver);
	  driver.manage().window().maximize();
	  agregarHome.seleccionarProducto(productos[0]);
	  agregarHome.agregarProducto(1);
	  agregarHome.goBack();
	  agregarHome.goBack();
	  //agregarHome.seleccionarProducto(productos[1]);
	  //agregar
	  agregarHome.seleccionarProducto(productos[1]);
	  agregarHome.agregarProducto(1);
	  agregarHome.goBack();
	  agregarHome.goBack();
	  agregarHome.seleccionarProducto(productos[2]);
	  agregarHome.agregarProducto(1);
	  agregarHome.goBack();
	  agregarHome.goBack();
  }
  @BeforeClass
  public void beforeClass() {
	  //System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
  }

  @AfterClass
  public void afterClass() {
  }

}
