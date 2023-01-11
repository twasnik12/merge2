package com.ebay.pageObjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ebay.commons.BaseClass;

public class HomePage extends BaseClass{
	BaseClass b=new BaseClass();
//	public WebDriver driver;
	
		
	@FindBy(xpath="//input[@id='gh-ac']")
	WebElement search;

	@FindBy(xpath="//input[@id='gh-btn']")
	WebElement searchbtn;
	
	@FindBy(xpath="//h1[contains(text(),' results for ')]")
	WebElement find;
	
//	
	@FindBy(xpath="//a[normalize-space()='2']")
	WebElement clickPage2;
	
//	
//	

	public HomePage()
	{
		PageFactory.initElements(b.driver, this);
	}


	public void searchServices(String MName) throws Exception
	{
		
		System.out.println("Tathagat");
		String ActualTitle = driver.getTitle();
		String expTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		Assert.assertEquals(ActualTitle, expTitle, "HomePage Open successfully!!");
		System.out.println("First Assertion pass........");
		search.sendKeys(MName);
		searchbtn.sendKeys(Keys.ENTER);
		List<WebElement> ProductReviews = driver.findElements(By.xpath("//div[@class=\"s-item__title\"]"));

		List<WebElement> starRaiting = driver.findElements(By.xpath("//div[@class='x-star-rating']"));

		List<WebElement> voteRaiting = driver.findElements(By.xpath("//span[@class='s-item__reviews-count']"));
		
		System.out.println("StarRating & voteRaiting Iphone Product page 1 list size is : "+starRaiting.size());
		System.out.println("                                          ");
		
		for(int j=0;j<starRaiting.size();j++) {
//			manage explicit wait for password
//			WebDriverWait wait = new WebDriverWait(driver, 70);
//			wait.until(ExpectedConditions.elementToBeClickable(starRaiting.get(j))).click();
			
			Thread.sleep(10000);
			try {
				starRaiting.get(j).click();
			}
			catch (Exception e) {
				
				System.out.println(e);
			}
		    
		  
			for(int i=j;j<starRaiting.size();j++) {
				
			System.out.println("                                     ");
			//Thread.sleep(5000);
			String PN =driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div[1]/div/div/h1")).getText();
			//Thread.sleep(5000);
			String SR =driver.findElement(By.xpath("//*[@id=\"s0-0-19-5-11-12-3\"]/span[1]")).getText();
			//Thread.sleep(5000);
			String VR =driver.findElement(By.xpath("//*[@id=\"s0-0-19-5-11-12-3\"]/span[3]/a")).getText();
			
			if(PN.isEmpty()&&SR.isEmpty()&&VR.isEmpty()==false) {
				System.out.println("-------------------------------" );
			}else {
				String str1=SR.replaceAll("[^0-9]","");
				String str2=VR.replaceAll("[^0-9]","");
				int StarRating = Integer.parseInt(str1);
				int VoteRating = Integer.parseInt(str2);
				
				
				
				if(StarRating>400&&VoteRating>20) {
					System.out.println("Sr.No:"+j+": "+"Product name is :"+PN);
					System.out.println("Star rating is :"+SR);
					System.out.println("Vote rating is :"+VR);
				}else {
					System.out.println("Sr.No:"+j+"--> Product is Skiped " );
					
				}
				
				
				
			}
			
			driver.navigate().back();
			
			break;
			
			}
											     
            }
		
		
		clickPage2.click();
		
		List<WebElement> ProductReviews1 = driver.findElements(By.xpath("//div[@class=\"s-item__title\"]"));

		List<WebElement> starRaiting1 = driver.findElements(By.xpath("//div[@class='x-star-rating']"));

		List<WebElement> voteRaiting1 = driver.findElements(By.xpath("//span[@class='s-item__reviews-count']"));
		
		System.out.println("                                          ");
		System.out.println("StarRating & voteRaiting Iphone Product page 2 list size is  : "+starRaiting1.size());
		System.out.println("                                          ");
		
		
		for(int m=0;m<starRaiting1.size();m++) {
			
			Thread.sleep(10000);		  
		    starRaiting1.get(m).click();
		  
			for(int k=m;k<starRaiting1.size();k++) {
				
			System.out.println("                                  ");
			//Thread.sleep(5000);
			String PN =driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div[1]/div/div/h1")).getText();
			//Thread.sleep(5000);
			String SR =driver.findElement(By.xpath("//*[@id=\"s0-0-19-5-11-12-3\"]/span[1]")).getText();
			//Thread.sleep(5000);
			String VR =driver.findElement(By.xpath("//*[@id=\"s0-0-19-5-11-12-3\"]/span[3]/a")).getText();
			
			if(PN.isEmpty()&&SR.isEmpty()&&VR.isEmpty()==false) {
				System.out.println("-------------------------------" );
			}else {
				String str1=SR.replaceAll("[^0-9]","");
				String str2=VR.replaceAll("[^0-9]","");
				int StarRating = Integer.parseInt(str1);
				int VoteRating = Integer.parseInt(str2);
				
				
				
				if(StarRating>400&&VoteRating>20) {
					System.out.println("Sr.No :"+m+":"+"Product name is :"+PN);
					System.out.println("Star rating is :"+SR);
					System.out.println("Vote rating is :"+VR);
				}else {
					System.out.println("Sr.No:"+m+"--> Product is Skiped " );
					
				}
				
				
				
			}
			
			driver.navigate().back();
			
			break;
			
			}
	        }
		 
		
}
}	
