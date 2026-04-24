🚀 DemoQA Selenium BDD Framework
Bu proje, DemoQA platformu üzerindeki uçtan uca (E2E) test senaryolarını otomatize etmek için Java, Selenium ve Cucumber kullanılarak geliştirilmiş, yüksek sürdürülebilirlik odaklı bir test otomasyon framework'üdür.

🛠 Kullanılan Teknolojiler
Dil: Java

Otomasyon Aracı: Selenium WebDriver

Test Yaklaşımı: BDD (Behavior Driven Development)

Framework: Cucumber & TestNG

Tasarım Deseni: Page Object Model (POM)

Raporlama: Allure Reports

Bağımlılık Yönetimi: Maven

🏗 Proje Mimarisi
Proje yapısı, kodun tekrar kullanılabilirliğini (reusability) ve okunabilirliğini artırmak için katmanlı bir yapıda tasarlanmıştır:

base/: WebDriver yönetimi ve temel sayfa etkileşimleri.

pages/: Web elementlerinin ve sayfaya özgü metodların tutulduğu POM katmanı.

steps/: Gherkin adımlarının Java koduna dönüştürüldüğü tanımlamalar.

features/: İş gereksinimlerinin .feature dosyalarında Gherkin diliyle yazılmış senaryoları.

utils/: Konfigürasyon okuyucu ve ortak yardımcı metodlar.

🏃‍♂️ Testleri Çalıştırma
1. Yerel Ortamda Çalıştırma
   Tüm testleri Maven üzerinden terminal aracılığıyla tetikleyebilirsiniz:

Bash
mvn clean test
2. Rapor Oluşturma
   Test sonuçlarını interaktif Allure raporu olarak görüntülemek için:

Bash
# Rapor verilerini oluştur
mvn allure:report

# Raporu tarayıcıda aç
mvn allure:serve
📋 Mevcut Test Senaryoları
Şu anda otomatize edilmiş modüller:

✅ TextBox: Veri girişi ve doğrulama süreçleri.

✅ CheckBox: Dinamik seçim ve ağaç yapısı kontrolleri.

✅ Elements: Genel UI bileşenleri etkileşimleri.

🎯 Gelişim Planı
[ ] Paralel test çalıştırma desteğinin optimize edilmesi.

[ ] API testleri için RestAssured entegrasyonu.

[ ] GitHub Actions ile CI/CD hattının kurulması.