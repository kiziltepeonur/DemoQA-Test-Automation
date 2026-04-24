package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;


public class ElementsPage extends BasePage {

    //Elements sayfasını doğrulama

    // Sol menünün en tepesindeki "Elements" başlığı
    private final By solMenuBasligi = By.xpath("//div[@class='element-group'][1]//span[contains(@class, 'group-header')]");


    public ElementsPage() {

        super();
    }

    //Elements başlığı çift doğrulama ( url ve sol menüdeki Elements başlığı)
    @Step("{0} sayfası çifte doğrulama ile kontrol edilir")
    public void sayfaAcildiginiGuvenliDogrula(String beklenenSayfaAdi) {
        logger.info("'{}' sayfasının yüklendiği çifte yöntemle doğrulanıyor...", beklenenSayfaAdi);

        //Url kontrolü
        String mevcutUrl = driver.getCurrentUrl();
        Assert.assertTrue(mevcutUrl.contains("/elements"), "HATA: URL '/elements' içermiyor! Mevcut URL: " + mevcutUrl);
        logger.info("URL doğrulaması başarılı: URL '/elements' içeriyor.");

        // Element görünürlüğü kontrolü
        Assert.assertTrue(isVisible(solMenuBasligi), "HATA: Sol menüdeki 'Elements' başlığı görünür değil!");
        logger.info("Element görünürlüğü doğrulaması başarılı: Sol menü başlığı görünüyor.");

        logger.info("Çifte doğrulama başarılı. '{}' sayfasının doğru yüklendiği teyit edildi.", beklenenSayfaAdi);
    }

    @Step("Sol menüden \"{0}\" seçeneğine tıklanır")
    public void solMenudenSecenekTikla(String secenekAdi) {
        String xpathIfadesi = String.format("//span[text()='%s']", secenekAdi);
        By secenekLocator = By.xpath(xpathIfadesi);
        click(secenekLocator);
        logger.info("'{}' seçeneğine tıklandı.", secenekAdi);
    }


}
