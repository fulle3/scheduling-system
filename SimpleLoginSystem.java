import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SimpleLoginSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
            
        }

        scanner.close();
    }

    private static boolean authenticate(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("notepad.txt"))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
    
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }
}