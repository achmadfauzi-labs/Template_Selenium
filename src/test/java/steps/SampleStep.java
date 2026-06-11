package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import pages.SamplePage;
import utils.TestDataHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * SampleStep — CONTOH step definition
 * Hapus atau rename sesuai kebutuhan project.
 */
public class SampleStep extends BaseStep {

    SamplePage samplePage;

    @Given("saya membuka halaman {string}")
    public void sayaMembukaiHalaman(String url) {
        samplePage = new SamplePage(getDriver());
        samplePage.navigateTo(url);
    }

    @When("saya login sebagai role {string}")
    public void sayaLoginSebagaiRole(String role) {
        // Ambil data dari JSON, bukan hardcode
    User user = TestDataHelper.getUser(role);

    System.out.println("Login sebagai: " + user); 
    // Output: Login sebagai: User{role='standard', username='standard_user'}

    samplePage = new SamplePage(getDriver());
    samplePage.login(user.getUsername(), user.getPassword());
    }

    @When("saya login dengan {string} dan {string}")
    public void sayaLoginDenganUsernameDanPassword(String username, String password) {
        samplePage = new SamplePage(getDriver());
        samplePage.login(username, password);
    }

    @Then("saya melihat pesan error {string}")
    public void sayaMelihatPesanError(String expectedError) {
        samplePage = new SamplePage(getDriver());
        assertTrue("Error tidak ditampilkan", samplePage.isErrorDisplayed());
        assertEquals(expectedError, samplePage.getErrorMessage());
    }

    @Then("URL saat ini mengandung {string}")
    public void urlSaatIniMengandung(String urlFragment) {
        samplePage = new SamplePage(getDriver());
        assertTrue("URL tidak sesuai", samplePage.getCurrentUrl().contains(urlFragment));
    }
}
