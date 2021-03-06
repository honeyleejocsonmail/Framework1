package com.testsuite_regression;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.BookaFlightPage;
import com.pages.FindaFlightPage;
import com.pages.FlightConfirmationPage;
import com.pages.SelectaFlightPage;
import com.pages.WelcomePage;

public class TestCase_purchaseTicket extends BaseClass {

	WelcomePage wp;
	FindaFlightPage ff;
	SelectaFlightPage sf;
	BookaFlightPage bp;
	FlightConfirmationPage fcp;

	@Test
	public void purchaseAirTicket() {
		wp = new WelcomePage(driver);
		ff = new FindaFlightPage(driver);
		sf = new SelectaFlightPage(driver);
		bp = new BookaFlightPage(driver);
		fcp = new FlightConfirmationPage(driver);
		wp.signin("tutorial", "tutorial");
		ff.oneway_rdbtn.click();
		ff.setPassengersCount().selectByValue("1");
		ff.setFromPort().selectByValue("Frankfurt");
		ff.setOnMonth().selectByValue("10");
		ff.setOnDay().selectByValue("20");
		ff.setArrivalPort().selectByValue("Seattle");
		ff.setToMonth().selectByValue("2");
		ff.setToDay().selectByValue("21");
		ff.srvClass_rdbtn.click();
		ff.selectAirLine().selectByIndex(2);
		ff.Continue.click();
		sf.departairline.click();
		sf.returnairline.click();
		sf.resflightContinue.click();
		bp.firstName.sendKeys("Naresh");
		bp.lastName.sendKeys("Prajapati");
		bp.setMeal().selectByVisibleText("Hindu");
		bp.setCreditCardType().selectByVisibleText("Visa");
		bp.number.sendKeys("123456789");
		bp.setCcExpMonth().selectByVisibleText("04");
		bp.setCcExpYear().selectByVisibleText("2010");
		bp.ccFirstName.sendKeys("N");
		bp.ccMidName.sendKeys("R");
		bp.ccLastName.sendKeys("Prajapati");
		bp.securePurchase.click();
		Assert.assertTrue(driver.getTitle().equals("Flight Confirmation: Mercury Tours"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
