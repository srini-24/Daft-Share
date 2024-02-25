package com.rent240224.pro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class rent24022024 {
	
	public static void main(String[] args) throws InterruptedException{
		
		boolean status=false;
		String url="https://www.daft.ie/";
		String email="kolipakabunty1998@gmail.com";
		String password="Bunty@1998";
		
		By signin_loc=By.xpath("//a[contains(text(),'Sign in')]");
		By username_loc=By.xpath("//input[contains(@id,'username')]");
		By password_loc=By.xpath("//input[contains(@id,'password')]");
		By signin_btn=By.xpath("//input[contains(@value,'SIGN IN')]");
		By daft_loc=By.xpath("//img[contains(@alt,'Daft')]");
		By sharebtn_loc=By.xpath("//a[contains(text(),'Share')]");
		By county_loc=By.xpath("//div//input[contains(@id,'location-input')]");
		By acceptall_loc=By.xpath("//button/span[contains(text(),'Acc')]");
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_122.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(acceptall_loc).click();
		Thread.sleep(3000);
		driver.findElement(signin_loc).click();
		Thread.sleep(1200);
		driver.findElement(username_loc).sendKeys(email);
		Thread.sleep(1200);
		driver.findElement(password_loc).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(signin_btn).click();
		Thread.sleep(3000);
		driver.findElement(daft_loc).click();
		Thread.sleep(1200);
		driver.findElement(sharebtn_loc).click();
		Thread.sleep(1200);
		
		Filters(driver, "Dublin 6", "200", "600", "1", "6");
		
		int sizes=driver.findElements(By.xpath("//ul[contains(@data-testid,'results')]/li")).size();
		for(int i=1;i<=sizes;i++){
			ScrollUpDown(driver, By.xpath("//ul[contains(@data-testid,'results')]/li["+i+"]"));
			System.out.println("Size :" +i);
			driver.findElement(By.xpath("//ul[contains(@data-testid,'results')]/li["+i+"]")).click();
			System.out.println("I am Size :" +i);
			EmailAgent(driver);
			
		}
		driver.quit();
		
	} 
	
	
	public static boolean Filters(WebDriver driver,String countyname, String minprice, String maxprice,String mintenant, String maxteneant){
		try{
			By county_loc=By.xpath("//div//input[contains(@id,'location-input')]");
			By price_btn=By.xpath("//button[contains(text(),'Price')]");
			By done_btn=By.xpath("//button//span[contains(text(),'Done')]");
			By filter_btn=By.xpath("//span[contains(text(),'Filter')]");
			By otherroomates_loc=By.xpath("//label[contains(text(),'Other Housemates')]");
			By showbtn=By.xpath("//span[contains(text(),'Show')]");
					
			Thread.sleep(5000);
			driver.findElement(county_loc).click();
			Thread.sleep(2000);
			driver.findElement(county_loc).sendKeys(countyname);
			Thread.sleep(5000);
			driver.findElement(county_loc).sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			driver.findElement(price_btn).click();
			Thread.sleep(3000);
			
			WebElement tstdrpdwn1=driver.findElement(By.name("rentalPriceFrom"));
			Select drpdwn1=new Select(tstdrpdwn1);
			drpdwn1.selectByValue(minprice);
			
			Thread.sleep(1200);
			WebElement tstdrpwn2=driver.findElement(By.name("rentalPriceTo"));
			Select drpdwn2=new Select(tstdrpwn2);
			drpdwn2.selectByValue(maxprice);
			
			Thread.sleep(2000);
			driver.findElement(done_btn).click();
			
			Thread.sleep(2000);
			driver.findElement(filter_btn).click();
			Thread.sleep(2000);
			ScrollUpDown(driver, otherroomates_loc);
			WebElement testdrpdwn3=driver.findElement(By.name("numTenantsFrom"));
			Select drpdwn3=new Select(testdrpdwn3);
			drpdwn3.selectByValue(mintenant);
			
			Thread.sleep(2000);
			WebElement testdrpdwn4=driver.findElement(By.name("numTenantsTo"));
			Select drpdwn4=new Select(testdrpdwn4);
			drpdwn4.selectByValue(maxteneant);
			
			ScrollUpDown(driver, showbtn);
			driver.findElement(showbtn).click();
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean ScrollUpDown(WebDriver driver,By ele){
		try{
			Thread.sleep(1000);
			WebElement element=driver.findElement(ele);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(ele).isDisplayed();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public static boolean EmailAgent(WebDriver driver){
		try{
			By email_loc=By.xpath("//button[contains(@aria-label,'Email')]");
			By firstname_loc=By.xpath("//input[contains(@name,'firstName')]");
			By lastname_loc=By.xpath("//input[contains(@name,'lastName')]");
			By emailid_loc=By.xpath("//input[contains(@name,'email')]");
			By phone_loc=By.xpath("//input[contains(@name,'phone')]");
			By msg_loc=By.xpath("//textarea[contains(@name,'message')]");
			By send_btn=By.xpath("//button[contains(@aria-label,'Send')]");
			
			Thread.sleep(3000);
			ScrollUpDown(driver, email_loc);
			driver.findElement(email_loc).click();
			Thread.sleep(2000);
			driver.findElement(firstname_loc).sendKeys("ABC");
			Thread.sleep(2000);
			driver.findElement(lastname_loc).sendKeys("ABC");
			Thread.sleep(2000);
			driver.findElement(emailid_loc).sendKeys("test@gmail.com");
			Thread.sleep(2000);
			driver.findElement(phone_loc).sendKeys("+35380000000");
			Thread.sleep(2000);
			driver.findElement(msg_loc).sendKeys("Hello, I am ABC I hope this email finds you well. I am writing to inquire about the availability of a shared room in your property. I am a neat and clean individual, with no smoking or drinking habits. Currently, I am employed at [Organization Name] with a monthly salary of 2000p.m. As a graduate, I am seeking accommodation closer to my workplace, and your property seems like an ideal location. Could you please provide me with more information regarding the shared room and its amenities? Additionally, I would appreciate details regarding the rent and any other relevant terms. Thank you for considering my request. I look forward to hearing from you soon.");
			Thread.sleep(2000);
			driver.findElement(send_btn).click();
			Thread.sleep(2000);
			driver.navigate().back();

		}catch(Exception e){
			return false;
		}
		return true;
	}

}
