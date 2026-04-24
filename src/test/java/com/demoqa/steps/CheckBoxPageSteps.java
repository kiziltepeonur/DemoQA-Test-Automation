package com.demoqa.steps;

import com.demoqa.pages.CheckBoxPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class CheckBoxPageSteps {

    private final CheckBoxPage checkBoxSayfasi = new CheckBoxPage();
    private List<String> isaretlenenSecenekler;

    @Then("\"Check Box\" sayfası açıldığını doğrula")
    public void checkBoxSayfasiAcildiginiDogrula() {
        checkBoxSayfasi.sayfaAcildiginiDogrula();
    }

    @When("Kullanıcı \"Home\" klasörünü genişletir")
    public void kullaniciHomeKlasorunuGenisletir() {
        checkBoxSayfasi.homeKlasorunuGenislet();
    }

    @When("Kullanıcı aşağıdaki seçenekleri işaretler:")
    public void kullaniciAsagidakiSecenekleriIsaretler(DataTable dataTable) {
        // DataTable'ı tek sütunlu bir List<String>'e çeviriyoruz.
        this.isaretlenenSecenekler = dataTable.asList(String.class);
        checkBoxSayfasi.secenekleriIsaretle(this.isaretlenenSecenekler);
    }

    @Then("Seçilen seçeneklerin sonuç metninde göründüğünü doğrular")
    public void secilenSeceneklerinSonucMetnindeGorundugunuDogrular() {
        // Bir önceki adımda sakladığımız listeyi doğrulama için kullanıyoruz.
        checkBoxSayfasi.sonuclariDogrula(this.isaretlenenSecenekler);
    }
}
