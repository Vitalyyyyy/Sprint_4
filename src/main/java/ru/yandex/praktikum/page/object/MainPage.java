package ru.yandex.praktikum.page.object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private WebDriver driver;

    private String AccordionButtonLocator = ".//div[@id='accordion__heading-%s']";

    private String sectionQuestionsElementPanel  = ".//div[@id='accordion__panel-%s']/p";

    protected String[] accordionIndexArray = {"0","1","2","3","4","5","6","7"};



    public MainPage(WebDriver driver) {
        this.driver = driver;
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

}
