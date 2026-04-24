# DemoQA Test Otomasyon Projesi

Bu proje, [DemoQA](https://demoqa.com/ ) web sitesi için Java, Selenium WebDriver, Cucumber ve TestNG kullanılarak geliştirilmiş, **Page Object Model (POM)** tabanlı bir test otomasyon projesidir.

Projenin temel amacı, modern otomasyon pratiklerini (BDD, POM) kullanarak sürdürülebilir, okunabilir ve ölçeklenebilir test senaryoları oluşturmaktır.

---

### Kullanılan Teknolojiler

*   **Programlama Dili:** Java 17
*   **Otomasyon Kütüphanesi:** Selenium WebDriver
*   **Test Çatısı:** TestNG & Cucumber (BDD)
*   **Proje Yönetimi:** Apache Maven
*   **Tasarım Deseni:** Page Object Model (POM)
*   **Raporlama:** Allure Framework
*   **Loglama:** SLF4J & Logback

---

### Temel Özellikler

*   **Davranış Odaklı Geliştirme (BDD):** Cucumber ile yazılmış, herkesin anlayabileceği `Gherkin` formatında test senaryoları.
*   **Modüler Tasarım:** Page Object Model sayesinde UI değişikliklerine karşı dayanıklı ve bakımı kolay bir kod yapısı.
*   **Paralel Test Desteği:** TestNG sayesinde testlerin aynı anda birden fazla iş parçacığında (thread) çalıştırılmasına olanak tanır.
*   **Gelişmiş Raporlama:** Başarılı ve hatalı test adımlarını, ekran görüntülerini ve logları içeren interaktif Allure raporları.
*   **Harici Veri Yönetimi:** Test verileri (URL, tarayıcı tipi vb.) koddan bağımsız olarak `.properties` dosyaları üzerinden yönetilir.
*   **Dinamik Bekleme:** Elementlerin yüklenmesi için `Explicit Wait` stratejileri kullanılarak testlerin kararlılığı artırılmıştır.

---

### Test Edilen Senaryolar

*   **Text Box Formu:** Kullanıcı bilgilerinin forma girilmesi ve gönderilen bilgilerin doğrulanması.
*   **Check Box Seçimleri:** "Home" klasörü altındaki çeşitli öğelerin seçilmesi ve yapılan seçimlerin doğrulanması.
*   **Ana Sayfa ve Modül Geçişleri:** Ana sayfadaki modül kartlarının görünürlüğünün ve bu kartlara tıklandığında doğru sayfalara yönlendirilmenin kontrolü.

---

### Projeyi Çalıştırma

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
4.  **Sadece Belirli Bir Grubu Çalıştırın (Örn: @smoke ):**
    ```bash
    mvn clean test -Dcucumber.filter.tags="@smoke"
    ```

---

### Allure Raporunu Görüntüleme

Testler tamamlandıktan sonra raporu oluşturmak ve tarayıcıda açmak için:

```bash
mvn allure:serve
