package com.globantu.automation.maximiliano_gigena.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.globantu.automation.maximiliano_gigena.TestClass;

public class HomePage {
  private WebDriver driver;
  private static final String url = "https://www.travelocity.com";
  @FindBy(id = "package-origin")
  private WebElement origin;
  @FindBy(id = "package-destination")
  private WebElement destination;
  @FindBy(id = "#package-1-adults")
  private WebElement adults;
  @FindBy(id = "package-departing")
  private WebElement departDate;
  @FindBy(id = "package-returning")
  private WebElement returningDate;
  @FindBy(css = ".datepicker-paging.datepicker-next.btn-paging.btn-secondary.next")
  private WebElement calendarNext;
  @FindAll({@FindBy(css = ".datepicker-cal-date")}) // Use [data-day="13"][data-month="10"] to later
                                                    // specify the dates.
  private List<WebElement> availableDepartDates;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void go() {
    driver.navigate().to(url);
  }

  public void selectDepartureDate() {
    departDate.click();
    calendarNext.click();
    this.determineDepartureDate();
  }

  private void determineDepartureDate() {
    if (TestClass.dayToday >= 30) {
      if (TestClass.monthToday >= 10) {
        // TODO Analyze the case for last days of November and December.
        calendarNext.click();
        availableDepartDates.stream()
            .filter(we -> we.getAttribute("data-day").equals("1")
                && we.getAttribute("data-month").equals(Integer.toString(TestClass.monthToday % 2)))
            .findFirst().get().click();
      } else {
        calendarNext.click();
        availableDepartDates.stream()
            .filter(we -> we.getAttribute("data-day").equals("1")
                && we.getAttribute("data-month").equals(Integer.toString(TestClass.monthToday)))
            .findFirst().get().click();
      }
    } else if (TestClass.monthToday >= 10) {
      availableDepartDates.stream()
          .filter(we -> we.getAttribute("data-day").equals(Integer.toString(TestClass.dayToday))
              && we.getAttribute("data-month").equals(Integer.toString(TestClass.monthToday % 2)))
          .findFirst().get().click();
    } else {
      availableDepartDates.stream()
          .filter(we -> we.getAttribute("data-day").equals(Integer.toString(TestClass.dayToday))
              && we.getAttribute("data-month").equals(Integer.toString(TestClass.monthToday)))
          .findFirst().get().click();
    }

  }
}
