package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage extends BasePage {

    //Locatorlar
    private final By homeKlasorGenisletmeIkonu = By.className("rc-tree-switcher");
    private final By sonucMetni = By.id("result");

    //Sayfa Doğrulama
    @Step("\"Check Box\" sayfasının açıldığı doğrulanır")
    public void sayfaAcildiginiDogrula() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkbox"), "HATA: URL 'checkbox' içermiyor!");
        logger.info("\"Check Box\" sayfasının URL'si doğrulandı.");
    }

    //Eylemler
    @Step("\"Home\" klasörü genişletilir")
    public void homeKlasorunuGenislet() {
        click(homeKlasorGenisletmeIkonu);
        logger.info("\"Home\" klasörü genişletildi.");
    }

    @Step("Belirtilen seçenekler işaretlenir")
    public void secenekleriIsaretle(List<String> secenekler) {
        for (String secenek : secenekler) {

            String xpathIfadesi = String.format("//span[text()='%s']/parent::span/preceding-sibling::span[contains(@class, 'rc-tree-checkbox')]", secenek);
            By secenekLocator = By.xpath(xpathIfadesi);

            try {

                click(secenekLocator);
                logger.info("'{}' seçeneği işaretlendi.", secenek);

            } catch (Exception e) {
                logger.warn("'{}' seçeneğine normal tıklanamadı, direkt metne tıklama veya JS deneniyor...", secenek);

                try {
                    By textLocator = By.xpath(String.format("//span[text()='%s']", secenek));
                    click(textLocator);
                    logger.info("'{}' metnine tıklanarak işaretlendi.", secenek);
                } catch (Exception ex) {
                    logger.error("Element bulunamadı veya tıklanamadı: " + ex.getMessage());
                }
            }
        }
    }

    //Sonuç Doğrulama
    @Step("Seçilen seçeneklerin sonuç metninde göründüğü doğrulanır")
    public void sonuclariDogrula(List<String> beklenenSecenekler) {
        String gelenSonucMetni = getText(sonucMetni);
        logger.info("Alınan sonuç metni: {}", gelenSonucMetni);

        for (String beklenen : beklenenSecenekler) {

            Assert.assertTrue(gelenSonucMetni.contains(beklenen.toLowerCase()),
                    "HATA: Sonuç metni, '" + beklenen + "' seçeneğini içermiyor!");
            logger.info("'{}' seçeneğinin sonuç metninde olduğu doğrulandı.", beklenen);
        }
    }
}
