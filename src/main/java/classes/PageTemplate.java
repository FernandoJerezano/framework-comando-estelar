package classes;

import org.openqa.selenium.WebDriver;

public class PageTemplate {
protected WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public PageTemplate (WebDriver driver) {
		this.driver = driver;
	}
	
	public void goBack () {
		this.driver.navigate().back();
	}
	
	public void goForward() {
		this.driver.navigate().forward();
	}
}
