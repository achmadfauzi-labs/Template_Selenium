package models;

/**
 * User — model class untuk data user dari users.json
 */
public class User {

    private String role;
    private String username;
    private String password;

    // Constructor
    public User(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getRole()     { return role; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "User{role='" + role + "', username='" + username + "'}";
    }
}
