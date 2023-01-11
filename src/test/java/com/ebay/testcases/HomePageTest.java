package com.ebay.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ebay.commons.BaseClass;
import com.ebay.pageObjects.HomePage;
import com.ebay.utilities.TestUtil;

public class HomePageTest extends BaseClass{
	HomePage hp;
	static String wbsheet="Services";//Services is sheet name thar are used in project
	public HomePageTest() throws IOException
	{
		super();
	}

	@BeforeMethod()
	public void setup()throws Exception
	{
		launchApp();
		hp = new HomePage();
	}	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{

		ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();

	}

	@Test(dataProvider="getTestData")//getTestData is methode is used in DataProvider annotation
	public void empdetails(String MName) throws Exception{
		
		hp.searchServices(MName);
//		hp.allProduct();
//		hp.getProductName();

	}
		@AfterMethod()
		public void teardown()
		{
			driver.quit();
		}
}
