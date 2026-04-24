package com.demoqa.steps;


import com.demoqa.base.Driver;
import com.demoqa.pages.HomePage;
import com.demoqa.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("Kullanıcı ana sayfaya gider")
    public void kullanıcıAnaSayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Then("Sayfa başlığı {string} olmalı")
    public void sayfaBasligi(String beklenenBaslik) {

        homePage.anaSayfaBasliginiDogrula(beklenenBaslik);
    }

    @And("Ana sayfada {string} kartını görmeli")
    public void anaSayfadaKartınıGörmeli(String kartAdi) {

        homePage.kategoriKartininGorunurlugunuKontrolEt(kartAdi);
    }

    @When("Ana sayfada {string} kartına tıkla")
    public void ana_sayfada_kartina_tikla(String kartAdi) {
        homePage.kategoriKartinaTikla(kartAdi);
    }


}
