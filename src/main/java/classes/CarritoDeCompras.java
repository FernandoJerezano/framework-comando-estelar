package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CarritoDeCompras extends PageTemplate{

	public CarritoDeCompras(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void main() {
		
	}

	public void seleccionarProducto(String productoEscoger) {
		WebElement selectProducto = driver.findElement(By.xpath("//a[@href='/products/"+ productoEscoger+"']"));
		selectProducto.click();
		
	}
	
	public void seleccionarCategoria(String categoriaEscoger, String productoEscoger) {
		WebElement selectCategoria = driver.findElement(By.xpath("//a[@href='/t/"+categoriaEscoger+"']"));
		selectCategoria.click();
		WebElement selectProducto = driver.findElement(By.xpath("//a[@href='/products/"+ productoEscoger+"']"));
		selectProducto.click();
	}
	
	public void agregarProducto(int cantidadProductos) {
		WebElement agregarCantidad = driver.findElement(By.id("quantity"));
		//agregarCantidad.sendKeys(""+cantidadProductos);
		WebElement agregarACarrito = driver.findElement(By.id("add-to-cart-button"));
		agregarACarrito.click();
	}
	
	public void buscarProducto(String nombreProducto) {
		WebElement buscarElement = driver.findElement(By.id("keywords"));
		//agregarCantidad.sendKeys(""+cantidadProductos);
		buscarElement.sendKeys(nombreProducto);
		WebElement agregarACarrito = driver.findElement(By.xpath("//*[@class='btn btn-success']"));
		agregarACarrito.click();
	}
	
}
