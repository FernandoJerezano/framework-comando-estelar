package tests;

import org.testng.annotations.Test;

import classes.CarritoDeCompras;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SeleccionarCategoriaTest {
	String driverPath = "C:\\Academia SDET\\libs\\chromedriver.exe";
	String baseUrl = "https://demosite.appvance.com/";
	WebDriver driver;
	String productos[] = {"ruby-on-rails-tote?taxon_id=3","ruby-on-rails-mug?taxon_id=4","ruby-on-rails-baseball-jersey?taxon_id=5","spree-bag","spree-tote"};
	String categorias[] = {"bags","mugs","clothing"};
	
  @Test
  public void f() {
	  CarritoDeCompras seleccionarCategoria = new CarritoDeCompras(driver);
	  driver.manage().window().maximize();
	  seleccionarCategoria.seleccionarCategoria(categorias[0],productos[0]);
	  seleccionarCategoria.agregarProducto(0);
	  seleccionarCategoria.goBack();
	  seleccionarCategoria.goBack();
	  seleccionarCategoria.goBack();
	  seleccionarCategoria.seleccionarCategoria(categorias[1],productos[1]);
	  seleccionarCategoria.agregarProducto(0);
	  seleccionarCategoria.goBack();
	  seleccionarCategoria.goBack();
	  seleccionarCategoria.goBack();
	  
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
