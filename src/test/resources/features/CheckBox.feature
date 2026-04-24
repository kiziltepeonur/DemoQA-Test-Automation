@regression
Feature: Check Box Fonksiyonları
  Kullanıcı olarak Check Box sayfasındaki kutuları işaretleyebilmeli ve sonuçları doğrulayabilmeliyim.

  Background:
    Given Kullanıcı ana sayfaya gider
    When Ana sayfada "Elements" kartına tıkla
    And Kullanıcı sol menüden "Check Box" seçeneğine tıklar

  Scenario: Kullanıcı "Home" klasörünü genişletir ve bazı seçimler yapar

    # Bu adım, bu senaryoya özel, benzersiz bir doğrulama adımıdır.
    Then "Check Box" sayfası açıldığını doğrula

    When Kullanıcı "Home" klasörünü genişletir
    And Kullanıcı aşağıdaki seçenekleri işaretler:
      | Desktop |
      | Documents |
      | Downloads |
    Then Seçilen seçeneklerin sonuç metninde göründüğünü doğrular
