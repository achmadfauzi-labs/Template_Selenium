package utils;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitHelper — kumpulan explicit wait yang sering dipakai
 * Menghindari Thread.sleep() yang tidak efisien
 *
 * Cara pakai:
 *   WaitHelper wait = new WaitHelper(driver);
 *   wait.waitUntilVisible(element);
 *   wait.waitUntilClickable(element);
 */
public class WaitHelper {

    private final WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        int timeout = ConfigReader.getInt("explicit.wait");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WaitHelper(WebDriver driver, int customTimeoutSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(customTimeoutSeconds));
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitUntilInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitUntilUrlContains(String urlFragment) {
        return wait.until(ExpectedConditions.urlContains(urlFragment));
    }

    public boolean waitUntilTitleContains(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }
}
