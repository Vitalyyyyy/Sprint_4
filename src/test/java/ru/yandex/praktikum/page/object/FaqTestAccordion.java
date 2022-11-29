package ru.yandex.praktikum.page.object;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqTestAccordion {

    private WebDriver driver;
    private final String expectedText;

    protected final int index;



    public FaqTestAccordion(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;


    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] compareTexData() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее." },
                { 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }
    @Test
    public void checkFaqItems() {
        driver = new ChromeDriver();
        MainPage objFaqAccordion = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        objFaqAccordion.clickAccordionItem(index);
        String actualText = objFaqAccordion.getAccordionText(index);
        assertEquals("Ответ не совпадает", expectedText, actualText);


    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
