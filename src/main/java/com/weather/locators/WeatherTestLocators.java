package com.weather.locators;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.weather.utils.PropertyReader;

public class WeatherTestLocators {

	WebDriver driver;
	PropertyReader reader = new PropertyReader();
	String appUrl = reader.readApplicationFile("AppUrl");

	public WeatherTestLocators(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public @FindBy(id = "h_sub_menu") WebElement clickSubMenu;
	public @FindBy(xpath = "//a[text()='WEATHER']") WebElement clickWeatherTab;
	public @FindBy(id = "searchBox") WebElement enterCityName;
	public @FindBy(id = "Amritsar") WebElement selectCity;
	public @FindBy(xpath = "//div[text()='Amritsar']") WebElement clickOnCityInMap;
	public @FindBy(xpath = "//div[@class='leaflet-popup-content']/div/span[4]") WebElement getCityTemperatureDetails;

	public void openApplication() {
		driver.get(appUrl);
	}
			
	public void enterCityNameInSearchBox(String city) throws InterruptedException {
		Thread.sleep(2000);
		enterCityName.sendKeys(city);
		selectCity.click();
	}
	
	public void clickOnCityInMap(String city) {

		clickOnCityInMap.click();
	}

	public String getTempartureDetailsFromUI()
	{
		String tempDetails= getCityTemperatureDetails.getText();
		String[] getTemp = tempDetails.split("Degrees:");
		return getTemp[1].trim();
	}
}
