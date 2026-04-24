package com.demoqa.base;

import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    //Her teste kendi özel tarayıcısını vererek paralel çalışmayı %100 güvenli hale getirmek için.
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    //Bu sınıftan 'new Driver()' ile yanlışlıkla nesne üretilmesini engellemek için.
    private Driver() {}

     //test için bir tarayıcı yoksa, config'den okuyup yenisini yaratır. Varsa, mevcut olanı verir.
    public static WebDriver getDriver() {

        if (driverThreadLocal.get() == null) {

            //Tarayıcı tipini tek bir merkezi yerden (config.properties) yönetmek için.
            String browser = ConfigReader.getProperty("browser");

            WebDriver driver;

            switch (browser.toLowerCase().trim()) {
                case "firefox":

                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    //Chrome için özel ayar nesnesi oluştur.
                    ChromeOptions options = new ChromeOptions();

                    // Chrome bir otomasyon yazılımı tarafından kontrol ediliyor" bildirimini kaldır.
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                    //bilgi balonlarını ve pop-up'ları devre dışı bırak.
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--start-maximized");

                    // Tarayıcıyı bu özel ayarlarla başlat.
                    driver = new ChromeDriver(options);
                    break;
            }

            //Yaratılan bu yeni tarayıcıyı, sadece mevcut teste özel olan "kutuya" koymak için.
            driverThreadLocal.set(driver);
        }
        //Mevcut testin kendi özel tarayıcısını geri döndürmek için.
        return driverThreadLocal.get();
    }


    //Test bittiğinde, o teste ait tarayıcıyı tamamen kapatmak ve hafızayı temizlemek için
    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
