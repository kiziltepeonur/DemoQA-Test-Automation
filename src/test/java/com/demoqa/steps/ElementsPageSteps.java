package com.demoqa.steps;

import com.demoqa.pages.ElementsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElementsPageSteps {

    ElementsPage elementsSayfasi = new ElementsPage();

    @Then("Elements modülünde {string} sayfası açıldığını doğrula")
    public void sayfasıAçıldığınıDoğrula(String sayfaAdi) {
        elementsSayfasi.sayfaAcildiginiGuvenliDogrula(sayfaAdi);

    }

    @When("Kullanıcı sol menüden {string} seçeneğine tıklar")
    public void kullaniciSolMenudenSecenegineTiklar(String secenekAdi) {
        elementsSayfasi.solMenudenSecenekTikla(secenekAdi);
    }


}
