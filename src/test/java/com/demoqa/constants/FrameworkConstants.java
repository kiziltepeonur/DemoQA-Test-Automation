package com.demoqa.constants;

import java.time.Duration;

//Süre, path, framework bilgisi gibi değişmeyen değerler burada tutulur.
public class FrameworkConstants {

    //new FrameworkConstants() yapılmasını engellemek için
    private FrameworkConstants(){
        throw new UnsupportedOperationException("\"Bu sınıf sadece sabit değerler içerir");
    }

    //Selenium wait sürelerini tek yerden yönetmek için
    public  static  final Duration DEFAULT_TIMEOUT =Duration.ofSeconds(15);

    //Projenin ana klasör yolunu dinamik almak için
    public static final String PROJECT_PATH =
            System.getProperty("user.dir");

    //config.properties dosyasının yerini sabitlemek için
    public static final String CONFIG_FILE_PATH =
            PROJECT_PATH + "/src/test/resources/config.properties";

    //Allure raporlarının üretileceği klasör
    public static final String ALLURE_RESULTS_PATH =
            PROJECT_PATH + "/target/allure-results";

    //Raporlarda framework adını göstermek için
    public static final String FRAMEWORK_NAME = "DemoQA Automation Framework";

    //Versiyon takibi yapmak için
    public static final String FRAMEWORK_VERSION = "1.0.0";
}
