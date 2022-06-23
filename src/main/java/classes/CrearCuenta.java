package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrearCuenta {

	
	WebDriver driver;
	
	public CrearCuenta(WebDriver driver) {
		this.driver = driver;;
	}
	
	public void ingresarDatosCuenta(String nombreUsuario, String contrasena) {
		WebElement userName = driver.findElement(By.id("spree_user_email"));
		userName.sendKeys(nombreUsuario);
		
		WebElement password = driver.findElement(By.id("spree_user_password"));
		password.sendKeys(contrasena);
		
		WebElement passwordConf = driver.findElement(By.id("spree_user_password_confirmation"));
		passwordConf.sendKeys(contrasena);
		
		WebElement createAcc = driver.findElement(By.name("commit"));
		createAcc.click();
	}
	
}
