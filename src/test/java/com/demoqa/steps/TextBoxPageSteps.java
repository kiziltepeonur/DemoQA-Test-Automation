package com.demoqa.steps;

import com.demoqa.pages.TextBoxPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class TextBoxPageSteps {

    private final TextBoxPage textBoxSayfasi = new TextBoxPage();

    // Bu Map, senaryo boyunca, adımlar arasında veri taşımak için kullanılacak.
    private Map<String, String> girilenBilgiler;

    @Then("\"Text Box\" sayfası açıldığını doğrula")
    public void textBoxSayfasiAcildiginiDogrula() {
        textBoxSayfasi.sayfaAcildiginiDogrula();
    }

    @When("Kullanıcı aşağıdaki bilgileri girer:")
    public void kullaniciAsagidakiBilgileriGirer(DataTable dataTable) {
        // DataTable'ı tek bir satırlık Map'e çeviriyoruz.
        this.girilenBilgiler = dataTable.asMap(String.class, String.class);

        // Page nesnesindeki metodu, bu bilgilerle çağırıyoruz.
        textBoxSayfasi.formuDoldur(this.girilenBilgiler);
    }

    @When("Kullanıcı formu submit eder")
    public void kullaniciFormuSubmitEder() {
        textBoxSayfasi.formuGonder();
    }

    @Then("Girilen bilgilerin doğru şekilde gösterildiğini doğrular")
    public void girilenBilgilerinDogruSekildeGosterildiginiDogrular() {
        // Bir önceki adımda sakladığımız 'girilenBilgiler' Map'ini,
        // doğrulama metoduna parametre olarak gönderiyoruz.
        textBoxSayfasi.girilenBilgileriDogrula(this.girilenBilgiler);
    }
}
