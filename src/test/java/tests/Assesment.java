package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;

import pages.Weather;

public class Assesment extends BasePage {
	
	@Test(priority=0,enabled=true)
	public void Scenario3() {
		Weather weatherreport = new Weather();
		weatherreport.Allsection();
		logger.log(LogStatus.INFO, "Clicking 'All Section");
		weatherreport.clickWeather();
		
		logger.log(LogStatus.INFO, "Clicking the 'Weather");
		weatherreport.WeatherValue();
	}
	
	@Test(priority=1)
	public void Scenario2() {
		Weather weatherreport = new Weather();
		weatherreport.Allsection();
		logger.log(LogStatus.INFO, "title verification");
		weatherreport.Titleverification();
		
		logger.log(LogStatus.INFO, "expanmore");
		weatherreport.expand();
	}
	@Test(priority=2,enabled=true)
	public void Scenario1() {
		Weather weatherreport = new Weather();
		weatherreport.Allsection();
		logger.log(LogStatus.INFO, "title verification");
		weatherreport.Titleverification();
		
		logger.log(LogStatus.INFO, "expanmore");
		weatherreport.expand();
	}

}
