package utils;

import models.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * TestDataHelper — membaca data test dari file JSON
 *
 * Cara pakai:
 *   User user = TestDataHelper.getUser("standard");
 *   loginPage.login(user.getUsername(), user.getPassword());
 */
public class TestDataHelper {

    private static final String USERS_PATH = "src/test/resources/testdata/users.json";

    // =============================================
    // AMBIL DATA USER
    // =============================================

    /**
     * Ambil user berdasarkan role
     * Role yang tersedia: "admin", "standard", "locked"
     *
     * Contoh:
     *   User user = TestDataHelper.getUser("standard");
     */
    public static User getUser(String role) {
        try {
            // Baca file JSON
            String content = new String(Files.readAllBytes(Paths.get(USERS_PATH)));
            JSONObject json = new JSONObject(content);
            JSONArray users = json.getJSONArray("users");

            // Cari user berdasarkan role
            for (int i = 0; i < users.length(); i++) {
                JSONObject userObj = users.getJSONObject(i);
                if (userObj.getString("role").equalsIgnoreCase(role)) {
                    return new User(
                        userObj.getString("role"),
                        userObj.getString("username"),
                        userObj.getString("password")
                    );
                }
            }

            throw new RuntimeException("User dengan role '" + role + "' tidak ditemukan di " + USERS_PATH);

        } catch (IOException e) {
            throw new RuntimeException("Gagal membaca file: " + USERS_PATH, e);
        }
    }

    /**
     * Ambil username saja berdasarkan role
     *
     * Contoh:
     *   String username = TestDataHelper.getUsername("admin");
     */
    public static String getUsername(String role) {
        return getUser(role).getUsername();
    }

    /**
     * Ambil password saja berdasarkan role
     *
     * Contoh:
     *   String password = TestDataHelper.getPassword("admin");
     */
    public static String getPassword(String role) {
        return getUser(role).getPassword();
    }
}
