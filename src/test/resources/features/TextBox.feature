@regression

Feature: Text Box Formu Fonksiyonları
  Kullanıcı olarak Text Box formunu doldurabilmeli ve gönderdiğim bilgilerin doğruluğunu teyit edebilmeliyim.

  Background:
    Given Kullanıcı ana sayfaya gider
    When Ana sayfada "Elements" kartına tıkla
    And Kullanıcı sol menüden "Text Box" seçeneğine tıklar

  Scenario: Kullanıcı Text Box formunu başarılı bir şekilde doldurur ve doğrular

    Then "Text Box" sayfası açıldığını doğrula

    When Kullanıcı aşağıdaki bilgileri girer:
      | tamAd           | Test Kullanıcı                |
      | eposta          | testkullanici@example.com     |
      | mevcutAdres     | 123 Test Caddesi, Test Şehri  |
      | kaliciAdres     | 456 Otomasyon Bulvarı, Oto Şehir |
    And Kullanıcı formu submit eder

    Then Girilen bilgilerin doğru şekilde gösterildiğini doğrular
