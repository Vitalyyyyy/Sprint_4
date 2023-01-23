package ru.yandex.praktikum.page.object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


import java.time.Duration;



public class OrderPage {
    private WebDriver driver;
    //Поле Имя
    private By firstFormName = By.xpath("//input[@placeholder='* Имя']");
    //Поле Фамилия
    private By firstFormSecondName = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private By firstFormAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");



    //ЭЛЕМЕНТЫ ПЕРВОЙ ФОРМЫ
    //Поле выбора Метро
    private final By firstFormSubwayStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле Телефон
    private By firstFormPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private By toSecondFormButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");



    //ЭЛЕМЕНТЫ ВТОРОЙ ФОРМЫ
    //Поле Когда привезти самокат
    private By secondFormCalendar = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //Выподающий список Срок аренды
    private By secondFormRent = By.xpath("//span[@class='Dropdown-arrow']");

    //Чекбокс выбора цвета Черный
    private By secondFormColorIsBlack = By.xpath("//input[@id='black']");

    //Чекбокс выбора цвета Серая безысходность
    private By secondFormColorIsGrey = By.xpath("//input[@id='grey']");

    //Поле Комментарий для курьера
    private By secondFormComment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //Кнопка Заказать
    private By secondFormOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //Окно подтверждения создания
    private By confirmWindow = By.xpath("//div[@class='Order_Text__2broi']");

   // Кнопка ДА
    private By confirmButton = By.xpath("//button[contains(text(),'Да')]");

    //Текст страницы оформленного заказа
    private By successWindow = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заполнение 1й формы
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
//Заполнение 2й формы
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

    //Клик кнопки подтверждения на 2й форме
    public void clickConfirmButtom() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmWindow));
        driver.findElement(confirmButton).click();

    }
//Поиск сообщения:"Заказ оформлен"
    public boolean checkSuccessWindow() {
        if (driver.findElements(successWindow).size() > 0) {
            return true;
        }
        return false;
    }
    }





