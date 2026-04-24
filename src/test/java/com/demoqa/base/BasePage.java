package com.demoqa.base;

import com.demoqa.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//Tüm Page sınıflarının temel aldığı ana sınıftır

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    //Her page kendi class adıyla log üretmesi için
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public BasePage() {
        this.driver = Driver.getDriver();

        //Bekleme süresi framework constants üzerinden yönetilir
        this.wait = new WebDriverWait(driver, FrameworkConstants.DEFAULT_TIMEOUT);
    }

    //Element tıklanabilir olana kadar bekler ve tıklar
    protected void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        logger.info("Clicked element: {}", by);
    }

    //Element görünür olunca text gönderir
    protected void type(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear(); // önce temizle
        element.sendKeys(text);
        logger.info("Typed '{}' into element: {}", text, by);
    }

    //Elementin görünen yazısını döndürür
    protected String getText(By by) {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
        logger.info("Text retrieved '{}' from element: {}", text, by);
        return text;
    }

    //Mevcut sayfanın başlığını döndürür
    protected String getTitle() {
        String title = driver.getTitle();
        logger.info("Page title: {}", title);
        return title;
    }

    //Element görünür mü kontrol eder
    protected boolean isVisible(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            logger.warn("Element not visible: {}", by);
            return false;
        }
    }

    // Elementi görünür alana scroll eder (ekrana getirir)
    protected void scrollToElement(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        logger.info("Scrolled to element: {}", by);
    }

    // Selenium click başarısız olursa (overlay vb.) JavaScript ile click atar
    protected void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}