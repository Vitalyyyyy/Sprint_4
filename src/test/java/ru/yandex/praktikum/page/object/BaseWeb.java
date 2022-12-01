package ru.yandex.praktikum.page.object;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public abstract class BaseWeb {

        protected WebDriver driver;

        @Before
        public void webdrivermanagerSetup() {
            driver = getDriver("chrome");
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.manage().window().maximize();
                }

                private WebDriver getDriver(String browserName) {
        if ("chrome".equals(browserName)) {
                    return driver = new ChromeDriver();
                }
        return  driver = new FirefoxDriver();
            }


            @After
            public void quitBrowser () {
                driver.quit();
            }
        }


