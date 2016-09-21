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
  public static int dayDeparture;
  public static int monthDeparture;
  public static int dayReturn;
  public static int monthReturn;

  public TestClass() {}

  @BeforeSuite(alwaysRun = true)
  public void setUpEnv() {
    today = new Date();
    calendar = Calendar.getInstance();
    calendar.setTime(today);
    dayToday = calendar.get(Calendar.DAY_OF_MONTH);
    monthToday = calendar.get(Calendar.MONTH);
    if (dayToday > 28) {
      dayDeparture = 1;
      if (monthToday > 9) {
        monthDeparture = calendar.get(Calendar.MONTH) % 3;
      } else {
        monthDeparture = calendar.get(Calendar.MONTH) + 3;
      }

    } else {
      dayDeparture = calendar.get(Calendar.DAY_OF_MONTH);
      if (monthToday > 9) {
        monthDeparture = calendar.get(Calendar.MONTH) % 2;
      } else {
        monthDeparture = calendar.get(Calendar.MONTH) + 2;
      }
    }
    if (dayToday > 28) {
      dayReturn = 1;
      if (monthToday > 7) {
        monthReturn = calendar.get(Calendar.MONTH) % 4;
      } else {
        monthReturn = calendar.get(Calendar.MONTH) + 4;
      }
    } else {
      dayReturn = calendar.get(Calendar.DAY_OF_MONTH);
      if (monthToday > 8) {
        monthReturn = calendar.get(Calendar.MONTH) % 3;
      } else {
        monthReturn = calendar.get(Calendar.MONTH) + 3;
      }
    }
  }

  @BeforeTest(alwaysRun = true)
  public void setUpDriver() {
    System.setProperty("webdriver.chrome.driver", System.getenv("DRIVERS")+"\\chromedriver.exe");
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
    hp.selectReturnDate();
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
