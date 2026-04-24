# 🚀 DemoQA Test Otomasyon Framework'ü

Bu proje, [DemoQA](https://demoqa.com/ ) web sitesi için **Java, Selenium WebDriver ve Cucumber** kullanılarak geliştirilmiş, **Page Object Model (POM)** tabanlı bir test otomasyon framework'üdür.

Projenin temel amacı, modern otomasyon pratiklerini kullanarak sürdürülebilir, okunabilir ve ölçeklenebilir test senaryoları oluşturmaktır.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Selenium-4-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium 4">
  <img src="https://img.shields.io/badge/Cucumber-7-23D96C?style=for-the-badge&logo=cucumber&logoColor=white" alt="Cucumber 7">
  <img src="https://img.shields.io/badge/TestNG-7-5A69A6?style=for-the-badge&logo=testng&logoColor=white" alt="TestNG 7">
  <img src="https://img.shields.io/badge/Maven-3-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven 3">
  <img src="https://img.shields.io/badge/Allure-2-FD5A28?style=for-the-badge&logo=allure-framework&logoColor=white" alt="Allure 2">
</p>

---

### 🛠️ Kullanılan Teknolojiler

*   **Programlama Dili:** `Java 17`
*   **Otomasyon Kütüphanesi:** `Selenium WebDriver`
*   **Test Çatısı:** `Cucumber (BDD )` & `TestNG`
*   **Proje Yönetimi:** `Apache Maven`
*   **Tasarım Deseni:** `Page Object Model (POM)`
*   **Raporlama:** `Allure Framework`
*   **Loglama:** `Logback` & `SLF4J`

---

### ✨ Temel Özellikler

*   **Modüler Tasarım:** Page Object Model sayesinde UI değişikliklerine karşı dayanıklı ve bakımı kolay bir kod yapısı.
*   **BDD Yaklaşımı:** Gherkin dili (`.feature` dosyaları) ile teknik olmayan kişilerin de anlayabileceği canlı dökümantasyon.
*   **Gelişmiş Raporlama:** Başarılı ve hatalı test adımlarını, hata anı ekran görüntülerini içeren interaktif Allure raporları.
*   **Harici Veri Yönetimi:** Test verileri (URL, timeout süreleri vb.) koddan bağımsız olarak `config.properties` dosyası üzerinden yönetilir.
*   **Merkezi Sabitler:** `FrameworkConstants` sınıfı ile proje içi dosya yolları ve statik değerlerin tek merkezden kontrolü.

---

### ✅ Test Edilen Senaryolar

*   **TextBox:** Kullanıcı bilgilerinin girilmesi ve gönderilen verilerin doğrulanması.
*   **CheckBox:** Hiyerarşik yapıdaki seçimlerin ve durum değişikliklerinin kontrolü.
*   **Elements:** Genel web element etkileşimleri ve validasyon süreçleri.

---

### 🏃‍♂️ Projeyi Çalıştırma

**Gereksinimler:**
*   Java JDK 17 (veya üstü)
*   Apache Maven

**Adımlar:**

1.  **Projeyi Klonlayın:**
    ```bash
    git clone https://github.com/kiziltepeonur/DemoQA-Test-Automation.git
    ```

2.  **Proje Klasörüne Gidin:**
    ```bash
    cd DemoQA-Test-Automation
    ```

3.  **Testleri Çalıştırın:** Tüm testleri çalıştırmak için:
    ```bash
    mvn clean test
    ```

---

### 📊 Allure Raporunu Görüntüleme

Testler tamamlandıktan sonra raporu oluşturmak ve tarayıcıda açmak için:

```bash
mvn allure:serve
