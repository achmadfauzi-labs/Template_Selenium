package pages;

import config.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

/**
 * BasePage — parent class untuk semua Page Object
 *
 * Semua halaman extends class ini agar dapat akses:
 * - driver
 * - waitHelper
 * - method umum (scroll, jsClick, dll)
 *
 * Cara pakai:
 *   public class LoginPage extends BasePage {
 *       public LoginPage(WebDriver driver) {
 *           super(driver);
 *       }
 *   }
 */
public class BasePage {

    protected WebDriver driver;
    protected WaitHelper waitHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    // ===== NAVIGASI =====
    public void navigateTo(String url) {
        driver.get(url);
    }

    public void navigateToBaseUrl() {
        driver.get(ConfigReader.get("base.url"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    // ===== INTERAKSI =====
    public void click(WebElement element) {
        waitHelper.waitUntilClickable(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        waitHelper.waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        waitHelper.waitUntilVisible(element);
        return element.getText().trim();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== JAVASCRIPT =====
    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
