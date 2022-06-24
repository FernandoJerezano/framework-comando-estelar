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
		WebElement inputEmail = driver.findElement(By.id("spree_user_email"));
		inputEmail.sendKeys(nombreUsuario);
		
		WebElement inputPassword = driver.findElement(By.id("spree_user_password"));
		inputPassword.sendKeys(contrasena);
		
		WebElement inputPasswordConf = driver.findElement(By.id("spree_user_password_confirmation"));
		inputPasswordConf.sendKeys(contrasena);
		
		WebElement btnCreateAcc = driver.findElement(By.name("commit"));
		btnCreateAcc.click();
	}
	
}
