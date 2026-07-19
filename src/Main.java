import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user1 = new User("Ahmet Tahsin", "Kalkan", 1234, 10000);
        User user2 = new User("Ayşe", "Yılmaz", 4321, 5000);
        User currentUser = Bank.loginSystem(scanner, user1);
        if (currentUser != null) {
            Bank.runAtmMenu(scanner, currentUser);
        } else {
            System.out.println("Login failed. Your card is blocked.");
        }
        scanner.close();
    }
}