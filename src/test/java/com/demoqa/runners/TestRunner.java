package com.demoqa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        // .feature Dosyalarının Yolu
        features = "src/test/resources/features",

        // Adım Tanımları ve Hooks Sınıflarının Yolu
        glue = {
                "com.demoqa.steps", // Adım tanımlarının bulunduğu paket
                "com.demoqa.base"   // Hooks sınıfının bulunduğu paket
        },

        // Çalıştırılacak Testleri Seçme
        tags = "", // Sadece belirli etiketli testleri çalıştırmak için. Örnek: "@smoke and not @wip"

        // Çıktı ve Raporlama Ayarları
        plugin = {
                // Konsol çıktısını daha okunaklı yapar.
                "pretty",

                // Test sonunda konsola bir özet basar (kaç test geçti/kaldı).
                "summary",

                // Hızlı kontrol için basit bir HTML raporu üretir.
                "html:target/cucumber-reports/report.html",

                // Jenkins gibi araçların okuyabilmesi için JSON formatında rapor üretir.
                "json:target/cucumber-reports/report.json",

                // Ana raporlama sistemimiz olan Allure için gerekli dosyaları üretir.
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },

        // 'true' ise, gerçek testleri çalıştırmaz, sadece eksik bir adım tanımı var mı diye kontrol eder.
        dryRun = false,

        // Konsol çıktısındaki anlamsız renk kodlarını kaldırarak, özellikle CI/CD ortamlarında okunabilirliği artırır.
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    //Testleri paralel çalıştırır
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
