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
  @FindAll({@FindBy(css = ".datepicker-cal-date")})
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
    determineDates(TestClass.dayDeparture, TestClass.monthDeparture);
  }

  public void selectReturnDate() {
    returningDate.click();
    calendarNext.click();
    determineDates(TestClass.dayReturn, TestClass.monthReturn);
  }

  private void determineDates(int day, int month) {
    availableDepartDates.stream()
        .filter(we -> we.getAttribute("data-day").equals(Integer.toString(day))
            && we.getAttribute("data-month").equals(Integer.toString(month)))
        .findFirst().get().click();
  }
}
