package com.globantu.automation.maximiliano_gigena;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.globantu.automation.maximiliano_gigena.pages.HomePage;

public class TestClass {
  private WebDriver driver = null;
  private HomePage hp;

  public static Date today;
  public static Calendar calendar;
  public static int dayToday;
  public static int monthToday;
  public static int yearToday;

  public TestClass() {}

  @BeforeSuite(alwaysRun = true)
  public void setUpEnv() {
    today = new Date();
    calendar = Calendar.getInstance();
    calendar.setTime(today);
    dayToday = calendar.get(Calendar.DAY_OF_MONTH);
    monthToday = calendar.get(Calendar.MONTH);
    yearToday = calendar.get(Calendar.YEAR);
  }

  @BeforeTest(alwaysRun = true)
  public void setUpDriver() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @BeforeMethod(alwaysRun = true)
  public void clear() {
    driver.manage().deleteAllCookies();
    hp = PageFactory.initElements(driver, HomePage.class);
  }

  @Test(groups = {"1"})
  public void bookFlight() {
    hp.go();
    hp.selectDepartureDate();
    System.out.println("Initiating test case number 1");
    Assert.assertTrue(true);
  }

  @Test(groups = {"2"})
  public void bookFlightHotelCar() {
    System.out.println("Initiating test case number 2");
    Assert.assertTrue(true);
  }

  @Test(groups = {"3"})
  public void searchHotelName() {
    System.out.println("Initiating test case number 3");
    Assert.assertTrue(true);
  }

  @Test(groups = {"4"})
  public void errorMessageForIncorrectDates() {
    System.out.println("Initiating test case number 4");
    Assert.assertTrue(true);
  }

  @Test(groups = {"5"})
  public void cruiseInformation() {
    System.out.println("Initiating test case number 5");
    Assert.assertTrue(true);
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() {
    driver.close();
    driver.quit();
  }
}
