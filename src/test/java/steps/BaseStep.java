package steps;

import org.openqa.selenium.WebDriver;
import static hooks.Hooks.driver;

/**
 * BaseStep — parent class untuk semua Step Definition
 *
 * Menyediakan akses ke driver tanpa import berulang.
 *
 * Cara pakai:
 *   public class LoginStep extends BaseStep {
 *       LoginPage loginPage = new LoginPage(getDriver());
 *   }
 */
public class BaseStep {

    protected WebDriver getDriver() {
        return driver;
    }
}
