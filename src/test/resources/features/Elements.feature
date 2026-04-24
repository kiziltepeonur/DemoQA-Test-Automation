@FunctionalTest

Feature: Elements Modülü Fonksiyonları
  Kullanıcı olarak Elements modülü altındaki araçlara erişebilmeliyim.

  Background:
    Given Kullanıcı ana sayfaya gider

  Scenario: Elements modülüne giriş ve sayfa doğrulaması

    When Ana sayfada "Elements" kartına tıkla
    Then Elements modülünde "Elements" sayfası açıldığını doğrula
