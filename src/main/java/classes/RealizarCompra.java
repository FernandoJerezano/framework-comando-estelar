package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealizarCompra {

	WebDriver driver;
	
	public RealizarCompra(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ingresarDatosDireccion(String firstName, String lastName, 
			String streetAddress, String city, String countryId, String stateId, 
			String zip, String phone) {
		
		WebElement inputFirstName 	= driver.findElement(By.id("order_bill_address_attributes_firstname"));
		inputFirstName.sendKeys(firstName);
		
		WebElement inputSecondName 	= driver.findElement(By.id("order_bill_address_attributes_lastname"));
		inputSecondName.sendKeys(lastName);
		
		WebElement inputAddress 	= driver.findElement(By.id("order_bill_address_attributes_address1"));
		inputAddress.sendKeys(streetAddress);
		
		WebElement inputCity 		= driver.findElement(By.id("order_bill_address_attributes_city"));
		inputCity.sendKeys(city);
		
		WebElement inputZipCode 	= driver.findElement(By.id("order_bill_address_attributes_zipcode"));
		inputZipCode.sendKeys(zip);
		
		WebElement inputPhone 		= driver.findElement(By.id("order_bill_address_attributes_phone"));
		inputPhone.sendKeys(phone);
		
		Select optCountry 			= new Select(driver.findElement(By.id("order_bill_address_attributes_country_id"))); 
		optCountry.selectByValue(countryId);
		Select optState				= new Select(driver.findElement(By.id("order_bill_address_attributes_state_id"))); 
		optState.selectByValue(stateId);
		
		WebElement btnSave = driver.findElement(By.name("commit"));
		btnSave.click();
	}
	
	public void ingresarDatosEntrega(int shippingMethod) {
		WebElement rdbShippingMethod = driver.findElements(By.xpath("//input[@name='order[shipments_attributes][0][selected_shipping_rate_id]']"))
															.get(shippingMethod);
		rdbShippingMethod.click();
		
		WebElement btnSave = driver.findElement(By.name("commit"));
		btnSave.click();
	}
	
	public void ingresarDatosPagoTarjeta(String nameOnCard, String cardNumber, 
			String expirationMonth, String expirationYear, String cvv) {
	
		WebElement inputNameOnCard = driver.findElement(By.id("name_on_card_2"));
		inputNameOnCard.sendKeys(nameOnCard);
		
		WebElement inputCardNumber = driver.findElement(By.id("card_number"));
		inputCardNumber.sendKeys(cardNumber);
		
		WebElement inputExpirationDate = driver.findElement(By.id("card_expiry"));
		inputExpirationDate.sendKeys(expirationMonth);
		inputExpirationDate.sendKeys(expirationYear);
		
		WebElement inputCardCode = driver.findElement(By.id("card_code"));
		inputCardCode.sendKeys(cvv);
		
		WebElement btnSave = driver.findElement(By.name("commit"));
		btnSave.click();
	}
	
	public void hacerCheckout() {
		
		WebDriverWait wait = new WebDriverWait(driver, 240);
		
		WebElement linkCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/cart']")));
		//WebElement linkCart = driver.findElement(By.xpath("//a[@href='/cart']"));
		linkCart.click();
		
		WebElement btnCheckout = driver.findElement(By.id("checkout-link"));
		btnCheckout.click();
	}
	
}
