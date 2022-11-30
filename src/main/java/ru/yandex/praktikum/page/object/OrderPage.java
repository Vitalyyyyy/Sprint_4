package ru.yandex.praktikum.page.object;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.time.Duration;
import java.util.List;


public class OrderPage {
    private WebDriver driver;
    private By firstFormName = By.xpath("//input[@placeholder='* Имя']");
    private By firstFormSecondName = By.xpath("//input[@placeholder='* Фамилия']");
    private By firstFormAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    private final By firstFormSubwayStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    private By firstFormPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By toSecondFormButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By secondFormCalendar = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By secondFormRent = By.xpath("//span[@class='Dropdown-arrow']");

    private By secondFormColorIsBlack = By.xpath("//input[@id='black']");
    private By secondFormColorIsGrey = By.xpath("//input[@id='grey']");
    private By secondFormComment = By.xpath("//input[@placeholder='Комментарий для курьера']");


    private By secondFormOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By confirmWindow = By.xpath("//div[@class='Order_Text__2broi']");
    private By confirmButton = By.xpath("//button[contains(text(),'Да')]");
    private By SuccessWindow = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstForm(String name, String secondName, String address, String metro, String phone) {
        driver.findElement(firstFormName).click();
        driver.findElement(firstFormName).sendKeys(name);
        driver.findElement(firstFormSecondName).click();
        driver.findElement(firstFormSecondName).sendKeys(secondName);
        driver.findElement(firstFormAddress).click();
        driver.findElement(firstFormAddress).sendKeys(address);
        driver.findElement(firstFormSubwayStationField).click();
        driver.findElement(firstFormSubwayStationField).sendKeys(metro);
        driver.findElement(firstFormSubwayStationField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(firstFormPhone).click();
        driver.findElement(firstFormPhone).sendKeys(phone);
        driver.findElement(toSecondFormButton).click();


    }

    public void fillSecondForm(String date, String rent, boolean isBlack, boolean isGrey, String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(secondFormCalendar));
        driver.findElement(secondFormCalendar).click();
        driver.findElement(secondFormCalendar).sendKeys(date);
        driver.findElement(secondFormRent).click();
        String locator = String.format("//div[text()='" + rent + "']");
        driver.findElement(By.xpath(locator)).click();
        if (isBlack == true) {
            driver.findElement(secondFormColorIsBlack).click();
        } else if (isGrey == true) {
            driver.findElement(secondFormColorIsGrey).click();
        }
        driver.findElement(secondFormComment).sendKeys(comment);
        driver.findElement(secondFormOrderButton).click();
    }

    public void clickConfirmButtom() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmWindow));
        driver.findElement(confirmButton).click();

    }

    public boolean checkSuccessWindow() {
        if (driver.findElements(SuccessWindow).size() > 0) {
return true;
        }else{
            return false;
        }

    }




}
