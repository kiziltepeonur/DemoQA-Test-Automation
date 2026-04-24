package com.demoqa.utils;

import com.demoqa.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


 //config.properties dosyasını okumak için kullanılan yardımcı sınıf.

public class ConfigReader {

    // Tüm config değerlerini tutar
    private static final Properties properties = new Properties();

    // Class ilk yüklendiğinde 1 kez çalışır
    static {
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)) {

            // Dosyayı yükle
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Config dosyası okunamadı!");
        }
    }

    /**
     * Config değerini getirir
     * Önce System Property bakar (env override için)
     * Yoksa config dosyasından alır
     */
    public static String getProperty(String key) {

        //Önce JVM parametresi var mı bak (örn: -Dbrowser=firefox)
        String value = System.getProperty(key);

        //Yoksa config dosyasından al
        if (value == null) {
            value = properties.getProperty(key);
        }

        //Hala yoksa hata fırlat (null-safe)
        if (value == null) {
            throw new RuntimeException("Config key bulunamadı: " + key);
        }

        return value;
    }
}
