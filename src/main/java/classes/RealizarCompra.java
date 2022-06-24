package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Autor: Fernando Rafael Jerezano Balderas
 * Fecha creación: 2022-06-24 
 * Fecha de modificación: 
 * Objetivo: 
 * 	contiene todos los métodos para realizar el proceso de compra.  
 * 
 * */
public class RealizarCompra {

	WebDriver driver;
	
	public RealizarCompra(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * descripcion: llena la información de la direccion de entrega de los productos
	 * parametros:
	 * 	firstName: el nombre del comprador
	 * 	lastName: apeelido del comprador
	 *  streetAddress: dirección de entrega
	 *  city: ciudad de entrega
	 *  countryId: identificador del país de entrega
	 *  stateId: identificicador del estado de entrega
	 *  zip: codigo postal
	 *  phone: telefono de contacto
	 * */
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
	
	/*
	 * descripcion: se elige la opción que vamos a tomar para el envio de lo comprado
	 * parametros:
	 * 	shippingMethod: el número de la opcion que vamos a elegir como tipo de envio (0-index)
	 * */
	public void ingresarDatosEntrega(int shippingMethod) {
		WebElement rdbShippingMethod = driver.findElements(By.xpath("//input[@name='order[shipments_attributes][0][selected_shipping_rate_id]']"))
															.get(shippingMethod);
		rdbShippingMethod.click();
		
		WebElement btnSave = driver.findElement(By.name("commit"));
		btnSave.click();
	}
	
	/*
	 * descripcion: llena el formulario de los datos de la tarjeta de crédito
	 * parametros:
	 * 	nameOnCard: nombre de la tarjeta
	 * 	cardNumber: numero de la tarjeta
	 * 	expirationMonth: mes en el que expira la tarjeta
	 * 	expirationYear: año en el que expira la tarjeta
	 * */
	public void ingresarDatosPagoTarjeta(String nameOnCard, String cardNumber, 
			String expirationMonth, String expirationYear, String cvv) {
	
		WebElement inputNameOnCard = driver.findElement(By.id("name_on_card_2"));
		inputNameOnCard.clear();
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
	
	/*
	 * descripcion: realiza el proceso de ir al carrito y hacer checkout
	 * */
	public void hacerCheckout() {
		
		WebDriverWait wait = new WebDriverWait(driver, 240);
		
		WebElement linkCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/cart']")));
		linkCart.click();
		//WebElement linkCart = driver.findElement(By.xpath("//a[@href='/cart']"));
				
		WebElement btnCheckout = driver.findElement(By.id("checkout-link"));
		btnCheckout.click();
	}
	
}



/*
 * Especificaciones:
 * 
 *  Notación: lowerCamelCase
 *  
 *  Variables: las variables tendrán un nombre descriptivo de acuerdo a la funcion que tengan.
 *  	Los parametros de las funciones tendrán la misma convencion.
 *  	Con una longitud entre 3 y 32 carácteres.
 *  	Ejemplo: contadorDeAlumnos;
 *  
 *  Métodos: los métodos tendrán un nombre descriptivo de acuerdo a la accion que realicen.
 *  	Con una longitud entre 5 y 50 carácteres.
 *  	Ejemplo: obtenCalificacionAlumno(int idAlumno);
 *  
 *  Objetos de selenium: los objetos de selenium tendrán como sufijo el tipo de 
 *  	elemento HTML que se está buscando.
 *  	Ejemplo: inputEmail, selPais, btnIniciarSesion, rdbTipoPago, etc.
 * 
 * 	Comentario:
 * 		Métodos: los metodos estarán con un comentario multilinea, descrbiendo de 
 * 			manera general que realiza este metodo.
 * 			Tambien se describirá lo que hace cada parametro, en caso de tener. 
 * 		Línea: los comentarios por línea estarán encima de la línea que se está comendando
 * 			ejemplo: // se incremente el numero de alumnos
 * 					 numeroDeAlumnos++;
 * */
