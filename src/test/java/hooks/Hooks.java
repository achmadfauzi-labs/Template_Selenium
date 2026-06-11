package hooks;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ScreenshotHelper;

public class Hooks {

    // Driver static agar bisa diakses dari semua Step class
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("========== SETUP SCENARIO ==========");
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("========== SCENARIO: " + scenario.getName() + " ==========");
        System.out.println("Status: " + scenario.getStatus());

        // Screenshot otomatis saat scenario gagal
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotHelper.takeAsBytes(driver);
            scenario.attach(screenshot, "image/png", "screenshot_" + scenario.getName());
            System.out.println("Screenshot diambil untuk scenario yang gagal.");
        }

        // Screenshot selalu diambil jika config = always
        if (ConfigReader.get("screenshot").equalsIgnoreCase("always")) {
            byte[] screenshot = ScreenshotHelper.takeAsBytes(driver);
            scenario.attach(screenshot, "image/png", "screenshot_" + scenario.getName());
        }

        DriverManager.quitDriver();
        driver = null;
        System.out.println("=====================================");
    }
}
