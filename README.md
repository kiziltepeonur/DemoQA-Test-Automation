DemoQA Test Otomasyon Framework'ü
Bu proje, DemoQA web sitesi için Java, Selenium WebDriver ve Cucumber kullanılarak geliştirilmiş, Page Object Model (POM) tabanlı bir test otomasyon framework'üdür.

Projenin temel amacı, modern otomasyon pratiklerini kullanarak sürdürülebilir, okunabilir ve ölçeklenebilir test senaryoları oluşturmaktır.

Kullanılan Teknolojiler
Programlama Dili: Java 17

Otomasyon Kütüphanesi: Selenium WebDriver

Test Çatısı: Cucumber (BDD) & TestNG

Proje Yönetimi: Apache Maven

Tasarım Deseni: Page Object Model (POM)

Raporlama: Allure Framework

Sürücü Yönetimi: WebDriverManager

Loglama: Log4j & SLF4J

Temel Özellikler
Modüler Tasarım: Page Object Model sayesinde UI değişikliklerine karşı dayanıklı ve bakımı kolay bir kod yapısı.

BDD Yaklaşımı: Gherkin dili (.feature dosyaları) ile teknik olmayan kişilerin de anlayabileceği canlı dökümantasyon.

Gelişmiş Raporlama: Başarılı ve hatalı test adımlarını, hata anı ekran görüntülerini içeren interaktif Allure raporları.

Harici Veri Yönetimi: Test verileri (URL, timeout süreleri vb.) koddan bağımsız olarak config.properties dosyası üzerinden yönetilir.

Merkezi Sabitler: FrameworkConstants sınıfı ile proje içi dosya yolları ve statik değerlerin tek merkezden kontrolü.

Test Edilen Senaryolar
TextBox: Kullanıcı bilgilerinin girilmesi ve gönderilen verilerin doğrulanması.

CheckBox: Hiyerarşik yapıdaki seçimlerin ve durum değişikliklerinin kontrolü.

Elements: Genel web element etkileşimleri ve validasyon süreçleri.

Projeyi Çalıştırma
Gereksinimler
Java JDK 17 (veya üstü)

Apache Maven

Adımlar:
Projeyi Klonlayın:

Bash
git clone https://github.com/kiziltepeonur/DemoQA-Test-Automation.git
Proje Klasörüne Gidin:

Bash
cd DemoQA-Test-Automation
Testleri Çalıştırın: Tüm testleri çalıştırmak için:

Bash
mvn clean test
Allure Raporunu Görüntüleyin: Testler tamamlandıktan sonra raporu tarayıcıda açmak için:

Bash
allure serve
(Bu komut için sisteminizde Allure Commandline'ın kurulu olması gerekmektedir.)