package com.demoqa.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * Bu sınıf test lifecycle yönetimini merkezi olarak kontrol eder.
 * SAĞLADIĞI ÖZELLİKLER:
 * - Driver initialization & cleanup
 * - Fail durumunda screenshot alma
 * - Allure report entegrasyonu
 * - Execution time tracking
 * - Structured logging
 */
public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    // Senaryo başlangıç zamanını tutmak için
    private long startTime;

    //HER SENARYODAN ÖNCE ÇALIŞIR
    @Before
    public void setUp(Scenario scenario) {

        startTime = System.currentTimeMillis();

        logger.info("========================================");
        logger.info("▶ SENARYO BAŞLIYOR: {}", scenario.getName());

        // Driver initialize edilir (thread-safe)
        Driver.getDriver();
    }

    //Her seneryodan sonra çalışır
    @After
    public void tearDown(Scenario scenario) {
        long duration = System.currentTimeMillis() - startTime;
        logger.info("⏱ SENARYO SÜRESİ: {} ms", duration);
        logger.info("▶ SENARYO BİTTİ: {} | STATUS: {}", scenario.getName(), scenario.getStatus());

        //Fail durumu yönetimi
        if (scenario.isFailed()) {
            logger.error("SENARYO BAŞARISIZ OLDU: Kanıtlar toplanıyor...");

            try {
                WebDriver driver = Driver.getDriver();
                if (driver != null) {
                    logger.info("Ekran görüntüsü alınıyor...");

                    // Ekran görüntüsünü byte dizisi olarak alıyoruz
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                    // Cucumber'ın 'attach' metodu ile raporlama sistemine (Allure, HTML vb.) ekliyoruz
                    scenario.attach(screenshot, "image/png", "Hata Anı Ekran Görüntüsü");

                    logger.info("Ekran görüntüsü başarıyla senaryo raporuna eklendi.");
                }
            } catch (Exception e) {
                logger.error("Ekran görüntüsü alınırken bir hata oluştu!", e);
            }
        }


        // Driver'ı kapat ve belleği temizle
        Driver.quitDriver();
        logger.info("========");
    }
}