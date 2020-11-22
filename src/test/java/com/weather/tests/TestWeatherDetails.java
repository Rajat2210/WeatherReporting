package com.weather.tests;

import org.testng.annotations.Test;
import com.weather.helper.GetWeatherDetailsFromAPI;
import com.weather.helper.MatchWeatherDetails;
import com.weather.locators.WeatherTestLocators;
import com.weather.utils.DriverFactory;
import com.weather.utils.PropertyReader;

public class TestWeatherDetails extends DriverFactory  {
	
	
	@Test
	public void getWeatherDetailsFromUIAndMatchWithAPIResponse() throws Exception
	{
		WeatherTestLocators weatherUIFunctions = new WeatherTestLocators(getDriver());
		GetWeatherDetailsFromAPI getAPIWeatherDeatils = new GetWeatherDetailsFromAPI();
		MatchWeatherDetails details = new MatchWeatherDetails();
		PropertyReader reader = new PropertyReader();
		String city = reader.readApplicationFile("City");
		
		// Open Weather application
		weatherUIFunctions.openApplication();
		
		// Enter city name in search box
		weatherUIFunctions.enterCityNameInSearchBox(city);
		
		// Click on City on map to get the weather details
		weatherUIFunctions.clickOnCityInMap(city);
		String uiTempDetails= weatherUIFunctions.getTempartureDetailsFromUI();
				
		// Get temperature details from API
		String apiTempDetails =getAPIWeatherDeatils.getAPIResponse(city);
		
		// Matching  UI & API response values and the test shall return a success if temperature difference is within a specified range, else return a user defined exception while marking the test as failed
		details.getTempDifference(Integer.parseInt(uiTempDetails), Integer.parseInt(apiTempDetails));
	}
}
