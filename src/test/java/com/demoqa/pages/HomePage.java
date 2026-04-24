package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super(); // BasePage'in constructor'ını çağırmak iyi bir alışkanlıktır.
    }

    //Web sitei doğrulama
    @Step("Sayfaya gidildikten sonra sayfa başlığı kontrol edilir")
    public void anaSayfaBasliginiDogrula(String beklenenBaslik) {

        String gelenBaslik = getTitle();

        Assert.assertEquals(gelenBaslik, beklenenBaslik, "HATA: Sayfa başlığı uyuşmuyor!");

        logger.info("Sayfa başlığı başarıyla doğrulandı: '{}'", gelenBaslik);
    }

    //Ana sayfadaki seçenekleri görünür olmasını doğrulama
    @Step("Açılan tarayıcıda ana sayfadaki seçenekler görünür")
    public void kategoriKartininGorunurlugunuKontrolEt(String kartAdi) {

        String xpathIfadesi = String.format("//h5[text()='%s']", kartAdi);
        By kartLokatoru = By.xpath(xpathIfadesi);

        boolean gorunurMu = isVisible(kartLokatoru);

        Assert.assertTrue(gorunurMu, "HATA: '" + kartAdi + "' kartı görünür değil!");

        logger.info("'{}' kartının görünür olduğu doğrulandı.", kartAdi);
    }


    //Ana sayfadaki herhangi bir kategori kartına, reklamları ve diğer
    @Step("Ana sayfadaki \"{0}\" kartına tıklanır")
    public void kategoriKartinaTikla(String kartAdi) {
        String xpathIfadesi = String.format("//h5[text()='%s']/ancestor::div[contains(@class, 'top-card')]", kartAdi);
        By kartLocator = By.xpath(xpathIfadesi);

        try {
            logger.info("'{}' kartına normal tıklama deneniyor...", kartAdi);
            click(kartLocator);
        } catch (Exception e) {
            logger.warn("Normal tıklama başarısız oldu! 'Element Click Intercepted' hatası alındı. JavaScript ile tıklama deneniyor...", e.getMessage());

            WebElement element = driver.findElement(kartLocator);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            js.executeScript("arguments[0].click();", element);
        }

        logger.info("'{}' kategori kartına başarıyla tıklandı.", kartAdi);
    }

}
