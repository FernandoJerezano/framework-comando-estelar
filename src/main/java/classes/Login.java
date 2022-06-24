package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Login extends PageTemplate{

	public static final String baseURL = "https://demosite.appvance.com/";
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	
	public void main() {
		
	}
	
	public void getLogin(String usuarioLogin, String passwordLogin) {
		WebElement loginElement = driver.findElement(By.id("link-to-login"));
		loginElement.click();
		WebElement userName = driver.findElement(By.id("spree_user_email"));
		userName.sendKeys(usuarioLogin);
		WebElement userPassword = driver.findElement(By.id("spree_user_password"));
		userPassword.sendKeys(passwordLogin);
		WebElement rememberElement = driver.findElement(By.id("spree_user_remember_me"));
		rememberElement.click();
		WebElement loginButton = driver.findElement(By.name("commit"));
		loginButton.click();
		
	}
	
	public void logout() {
		WebElement logoutElement = driver.findElement(By.xpath("//a[@href='/Logout']"));
		logoutElement.click();
	}
	
	
	
	public void searchWithPath(String textToSearch) {
		//WebElement buscador = this.driver.findElement(By.xpath(xpathBuscador));//TODO: tal cosa
		//buscador.sendKeys(textToSearch);
		//buscador.sendKeys(Keys.ENTER);
	}

}
