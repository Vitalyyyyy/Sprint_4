package ru.yandex.praktikum.page.object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    private String AccordionButtonLocator = ".//div[@id='accordion__heading-%s']";

    private String sectionQuestionsElementPanel = ".//div[@id='accordion__panel-%s']/p";

    protected String[] accordionIndexArray = {"0", "1", "2", "3", "4", "5", "6", "7"};

    private By OrderHeaderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    private By OrderBottomButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
private By CookieButton = By.xpath("//button[@id='rcc-confirm-button']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCookieButton(){
        driver.findElement(CookieButton).click();
    }
    // Прокрутка до элемента и клик.
    public void clickAccordionItem(int n) {
        String accordionHeadinglocator = String.format(AccordionButtonLocator, accordionIndexArray[n]);
        WebElement element = driver.findElement(By.xpath(accordionHeadinglocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(accordionHeadinglocator)).click();
    }

    // Поиск текста по аттрибуту в раскрытом элементе аккордиона.
    public String getAccordionText(int n) {
        String accordionAnswerlocator = String.format(sectionQuestionsElementPanel, accordionIndexArray[n]);
        return driver.findElement(By.xpath(accordionAnswerlocator)).getAttribute("innerHTML");
    }

    // Клик по кнопке заказа в Шапке
    public void clickOrderHeaderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(OrderHeaderButton));
        driver.findElement(OrderHeaderButton).click();
    }

    // Клик по кнопке Заказа на основной странице
    public void clickOrderBottomButton() {
        WebElement element = driver.findElement(OrderBottomButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(OrderBottomButton).click();


    }
}
