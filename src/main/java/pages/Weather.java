package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

public class Weather extends BasePage {
	
	public Weather() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='+ All Sections']")
	WebElement AllSections;

	@FindBy(xpath = "//*[@id='all-section-menu-modal']/div/div/div/div[1]/div[2]/ul/li[11]/a")
	WebElement Weather;
	
	 @FindBy(xpath = "//div[text()='kuala lumpur']//ancestor::li[1]//span")
	 WebElement Tempertaure;
	 
		@FindBy(xpath = "(//a[text()='Singapore'])[3]")
		WebElement Singapore;
		 @FindBy(xpath ="(//a[@class='h3__link h3__link-- list-object__heading-link'])[1]")
				 WebElement header;
		 
		 @FindBy(xpath ="//h1[@class='h1 h1--page-title']")
		 WebElement title;
		 @FindBy(xpath ="(//a[@class='article__read-full-story-button article__read-full-story-button--'])[2]")
		 WebElement expandmore;
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	public void Allsection()
	{
		AllSections.click();
	}
	
	public void clickWeather()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Weather.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Weather);
	}
	
	public void WeatherValue()
	{
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(Tempertaure);
		actions.perform();
	List<WebElement> temp= driver.findElements(By.xpath("//div[text()='kuala lumpur']//ancestor::li[1]//span"));
	for(int i=0;i<temp.size();i++)
	{
		//temp.get(i).getText();
		System.out.println(temp.get(i).getText());
		String val=temp.get(i).getText();
		//logger.log(LogStatus.INFO, "Weather of Kuala Lumpur”);
		logger.log(LogStatus.PASS, val);
		break;
	}
	}
	
	public void Titleverification()
	{
		
		executor.executeScript("arguments[0].click();", Singapore);
		//Singapore.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String headertext=	header.getText();
	System.out.println(headertext);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", header);
	executor.executeScript("arguments[0].click();", header);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(headertext.equals(title.getText()))
			logger.log(LogStatus.PASS, "Title is verified");
		else
			logger.log(LogStatus.FAIL, "failed to verify the header");
		
		
	}
	
	public void expand()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", expandmore);
		expandmore.click();
	}
	
	
	}


