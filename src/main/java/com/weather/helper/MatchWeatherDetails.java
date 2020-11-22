package com.weather.helper;

import org.testng.Assert;

import com.weather.utils.PropertyReader;

public class MatchWeatherDetails {

	public void getTempDifference(int t1, int t2) throws Exception {
		PropertyReader reader = new PropertyReader();
		int tempVariation = Integer.parseInt(reader.readApplicationFile("TempVariations"));

		if(Integer.compare(t1, t2) == -1)
		{
			if (t2 - t1 > tempVariation) {
				Assert.fail("temperature difference from ui "+t1+" and api "+t2+" is more than expected "+tempVariation+"");
			}
		}
		
		else if(Integer.compare(t1, t2) == 1)
		{
			if (t1 - t2 > tempVariation) {
				Assert.fail("temperature difference from ui "+t1+" and api "+t2+" is more than expected "+tempVariation+"");
			}
		}
		
		else
			Assert.assertTrue(true, "Temperature from ui and api is with in expected limit");
	}

}
