package ru.yandex.praktikum.page.object;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



@RunWith(Parameterized.class)
public class OrderPageTest {

    private WebDriver driver;


    private final boolean isOrderFromHeader;
    private final String name;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String rent;
    private final boolean isBlack;
    private final boolean isGrey;
    private final String comment;


    public OrderPageTest(boolean isOrderFromHeader, String name, String secondName, String address, String metroStation, String phone, String date, String rent, boolean isBlack, boolean isGrey, String comment) {

        this.isOrderFromHeader = isOrderFromHeader;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.rent = rent;
        this.isBlack = isBlack;
        this.isGrey = isGrey;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataFromOrder() {
        return new Object[][]{
                {true, "Дмитрий", "Рогозин", "Москва", "Черкизовская", "89112295453", "02.03.1451", "сутки", true, false, "Подогнать к ракете"},
                {true, "Дмифцвтрий", "Рогвфвфцозин", "Мацврс", "ВДНХ", "89122295453", "02.03.2004", "сутки", false, true, ""},


        };
    }

    @Test
    public void checkDaraFromOrder() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.clickCookieButton();
        if (isOrderFromHeader)
        mainPage.clickOrderHeaderButton();
            else
        mainPage.clickOrderBottomButton();
        orderPage.fillFirstForm(name, secondName, address, metroStation, phone);
        orderPage.fillSecondForm(date, rent, isBlack, isGrey, comment);
        orderPage.clickConfirmButtom();
        assertTrue("Заказ не создался.", orderPage.checkSuccessWindow());



    }

   @After
    public void teardown() {
        driver.quit();
    }

}