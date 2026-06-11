package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * SamplePage — CONTOH implementasi Page Object
 *
 * Hapus atau rename file ini sesuai halaman yang diuji.
 * Selalu extends BasePage agar dapat akses semua utility.
 */
public class SamplePage extends BasePage {

    // ===== ELEMEN HALAMAN =====
    // Gunakan @FindBy untuk mendefinisikan elemen
    // Pilih selector yang paling stabil: id > data-test > name > css > xpath

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    // ===== CONSTRUCTOR =====
    public SamplePage(WebDriver driver) {
        super(driver); // wajib panggil super(driver)
    }

    // ===== AKSI =====
    public void enterUsername(String username) {
        type(usernameField, username); // pakai method dari BasePage
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // ===== VERIFIKASI =====
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }
}
