package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader — membaca nilai dari config.properties
 *
 * Cara pakai:
 *   String url = ConfigReader.get("base.url");
 *   boolean headless = ConfigReader.getBoolean("headless");
 *   int timeout = ConfigReader.getInt("implicit.wait");
 */
public class ConfigReader {

    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";

    static {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Gagal membaca config.properties: " + CONFIG_PATH, e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key '" + key + "' tidak ditemukan di config.properties");
        }
        return value.trim();
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
