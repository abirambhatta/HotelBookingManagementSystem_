package MovieBooking.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User class handles user registration and authentication using file storage
 */
public class User {
    private String username;
    private String email;
    private String password;
    
    private static final String USER_FILE = "users.txt";
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    // Save user to file
    public static boolean saveUser(String username, String email, String password) {
        try (FileWriter writer = new FileWriter(USER_FILE, true)) {
            writer.write(username + "," + email + "," + password + "\n");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    // Check if user exists and password matches
    public static boolean authenticateUser(String identifier, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String email = parts[1];
                    String userPassword = parts[2];
                    
                    if ((identifier.equals(username) || identifier.equals(email)) 
                        && password.equals(userPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
    
    // Check if username or email already exists
    public static boolean userExists(String username, String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    if (parts[0].equals(username) || parts[1].equals(email)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}