package com.demoqa.pages;

import com.demoqa.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Map;

public class TextBoxPage extends BasePage {

    //Locatorlar
    private final By tamAdInput = By.id("userName");
    private final By epostaInput = By.id("userEmail");
    private final By mevcutAdresInput = By.id("currentAddress");
    private final By kaliciAdresInput = By.id("permanentAddress");
    private final By gonderButonu = By.id("submit");

    //Çıktı locatorları
    private final By ciktiTamAd = By.id("name");
    private final By ciktiEposta = By.id("email");
    private final By ciktiMevcutAdres = By.xpath("//p[@id='currentAddress']");
    private final By ciktiKaliciAdres = By.xpath("//p[@id='permanentAddress']");


    //Sayfa doğrulama
    @Step("Text Box sayfasının açıldığı doğrulanır")
    public void sayfaAcildiginiDogrula() {
        Assert.assertTrue(driver.getCurrentUrl().contains("text-box"), "HATA: URL 'text-box' içermiyor!");
        logger.info("Text Box sayfasının URL'si doğrulandı.");
    }

    @Step("Form bilgileri girilir")
    public void formuDoldur(Map<String, String> bilgiler) {
        type(tamAdInput, bilgiler.get("tamAd"));
        type(epostaInput, bilgiler.get("eposta"));
        type(mevcutAdresInput, bilgiler.get("mevcutAdres"));
        type(kaliciAdresInput, bilgiler.get("kaliciAdres"));
        logger.info("Form bilgileri girildi.");
    }

    @Step("Form gönderilir")
    public void formuGonder() {
        click(gonderButonu);
        logger.info("Gönder butonuna tıklandı.");
    }

    //Sonuç doğrulama
    @Step("Girilen bilgilerin doğruluğu kontrol edilir")
    public void girilenBilgileriDogrula(Map<String, String> beklenenBilgiler) {
        logger.info("Çıktı alanındaki bilgiler doğrulanıyor...");

        // Her bir alan için beklenen ve gelen değeri karşılaştır
        // getText metodundan gelen text'in başındaki "Name:", "Email:" gibi kısımları temizliyoruz.
        Assert.assertTrue(getText(ciktiTamAd).contains(beklenenBilgiler.get("tamAd")), "Tam Ad bilgisi uyuşmuyor!");
        Assert.assertTrue(getText(ciktiEposta).contains(beklenenBilgiler.get("eposta")), "E-posta bilgisi uyuşmuyor!");
        Assert.assertTrue(getText(ciktiMevcutAdres).contains(beklenenBilgiler.get("mevcutAdres")), "Mevcut Adres bilgisi uyuşmuyor!");
        Assert.assertTrue(getText(ciktiKaliciAdres).contains(beklenenBilgiler.get("kaliciAdres")), "Kalıcı Adres bilgisi uyuşmuyor!");

        logger.info("Tüm bilgiler başarıyla doğrulandı.");
    }
}
