package seleniumPractiseSessions;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day2_nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//1.open nyka 
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2.Mouseover on Brands and Mouseover on Popular
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		Actions brand1=new Actions(driver);
		brand1.moveToElement(brands).perform();
		Thread.sleep(2000);
		
		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		Actions popular1=new Actions(driver);
		popular1.moveToElement(popular).click().perform();
		
		//3.Click L'Oreal Paris
		driver.findElementByXPath("(//li[@class='brand-logo menu-links'])[5]").click();
		
		//4.Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> window= driver.getWindowHandles();
		List<String> windowhndle= new ArrayList<String>(window);
		driver.switchTo().window( windowhndle.get(1));
		System.out.println("window title is :"+driver.getTitle());
		
		//5.Click sort By and select customer top rated
		driver.findElementByXPath("//span[@title='POPULARITY']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(2000);
		
		//6.Click Category and click Shampoo
		WebElement category = driver.findElementByXPath("//div[text()='Category']");
		category.click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='Shampoo (21)']").click();
		
		//7.check whether the Filter is applied with Shampoo
		
		String shampoofilter = driver.findElementByXPath("//li[text()='Shampoo']").getText();
	

		if(shampoofilter.contains("Shampoo")) {
			System.out.println("filter applied");
		}
		else
		{
			System.out.println("filter is not applied");
		}
		
		
		//8. Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("//span[contains(text(),'Paris Colour Protect Shampoo')]").click();
		Thread.sleep(2000);
		
		
		//9.GO to the new window and select size as 175m
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowHandle2=new ArrayList<String>(windowHandle);
		String title = driver.switchTo().window(windowHandle2.get(2)).getTitle();
		System.out.println("window title is:"+title);
		
		driver.findElementByXPath("//span[text()='175ml']").click();
		
		//10.Print the MRP of the product
		  String cost = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		  System.out.println(cost);
		  
		  //11Click on ADD to BAG
		  driver.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();
		   //12.Go to Shopping Bag
		  driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		  
		  //13.Print the Grand Total amount
		  String total = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		  System.out.println("total amount is :"+total);
		  
		  //14.Click Proceed
		  driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		  
		  
		  //15.Click on Continue as Guest
		  driver.findElementByXPath("//button[@class='btn full big']").click();
		  
		 //16. Print the warning message (delay in shipment
		  String text = driver.findElementByXPath("//div[@class='message']").getText();
		  System.out.println("warning messageis:"+text);
		  
		  //17. Close all windows
		  driver.quit();
		

		
		
		
		
		
		
		
		

	}

}
