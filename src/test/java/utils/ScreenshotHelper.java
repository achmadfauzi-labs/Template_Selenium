package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotHelper — mengambil dan menyimpan screenshot
 *
 * Cara pakai:
 *   ScreenshotHelper.take(driver, "login_failed");
 */
public class ScreenshotHelper {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    public static String take(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        String filePath = SCREENSHOT_DIR + fileName;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot disimpan: " + filePath);
        } catch (IOException e) {
            System.err.println("Gagal menyimpan screenshot: " + e.getMessage());
        }

        return filePath;
    }

    public static byte[] takeAsBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
