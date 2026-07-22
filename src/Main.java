import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ahmet", "Kalkan", 1234, 10000));
        userList.add(new User("Ayse", "Yilmaz", 4321, 5000));
        userList.add(new User("Mehmet", "Demir", 1111, 7500));
        userList.add(new User("Zeynep", "Kaya", 2222, 12000));
        userList.add(new User("Can", "Celik", 3333, 3000));
        User currentUser = Bank.loginSystem(scanner, userList);
        if (currentUser != null) {
            Bank.runAtmMenu(scanner, currentUser);
        } else {
            System.out.println("\nLogin failed. Maximum attempts reached. System shutting down.");
        }

        scanner.close();
        }
    }
