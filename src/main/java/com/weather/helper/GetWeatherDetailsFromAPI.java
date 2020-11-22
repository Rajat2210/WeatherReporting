package com.weather.helper;

import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWeatherDetailsFromAPI {

	private static String apiKey= "7fe67bf08c80ded756e598d6f8fedaea";
	
	public String getAPIResponse(String cityName) throws IOException {
		
		String api= "https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+apiKey+"&units=metric";		
		Response response = RestAssured.get(api);
		return response.jsonPath().getString("main.temp");
	}
}
