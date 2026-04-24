@smoke
  Feature: Ana Sayfa Kontrolleri
    Kullanıcı olarak DemoQA sayfasındaki kartları görmeliyim

  Background:
  Given Kullanıcı ana sayfaya gider

    Scenario: Ana sayfadaki temel modüllerin görünürlüğünü doğrula
      Then Sayfa başlığı "demosite" olmalı
      And Ana sayfada "Elements" kartını görmeli
      And Ana sayfada "Forms" kartını görmeli
      And Ana sayfada "Alerts, Frame & Windows" kartını görmeli
      And Ana sayfada "Widgets" kartını görmeli
      And Ana sayfada "Interactions" kartını görmeli
