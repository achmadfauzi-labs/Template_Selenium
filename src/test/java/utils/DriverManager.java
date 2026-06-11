package utils;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * DriverManager — mengelola inisialisasi WebDriver
 * Support: Chrome, Firefox, Edge
 * Browser dan headless mode dibaca dari config.properties
 */
public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = ConfigReader.getBoolean("headless");
        int implicitWait = ConfigReader.getInt("implicit.wait");
        int pageLoad = ConfigReader.getInt("page.load.timeout");

        WebDriver newDriver = switch (browser) {
            case "firefox" -> createFirefoxDriver(headless);
            case "edge"    -> createEdgeDriver(headless);
            default        -> createChromeDriver(headless); // default: chrome
        };

        newDriver.manage().window().maximize();
        newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        newDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoad));

        return newDriver;
    }

    private static WebDriver createChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) options.addArguments("--headless");
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        if (headless) options.addArguments("--headless");
        return new EdgeDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
