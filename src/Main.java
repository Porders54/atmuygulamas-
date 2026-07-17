import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Deka Bank");
        User user1 = new User("Ahmet Tahsin","Kalkan",1234, 10000);
        User user2 = new User("Ayşe","Yılmaz",4321, 5000);
        User currentUser = loginSystem(scanner, user1);
        if (currentUser != null) {
            runAtmMenu(scanner, currentUser);
        } else {
            System.out.println("Login failed");
        }
        scanner.close();
    }
    public static User loginSystem(Scanner scanner, User user) {
        int remainingAttempts = 3;
        while (remainingAttempts > 0) {
            System.out.print("Please Enter Your Password (Attempts Left: " + remainingAttempts + "): ");
            int enterPassword = SafeInt(scanner);
            if (enterPassword == user.password) {
                System.out.println("Password Correct. Welcome, " + user.firstName + " " + user.lastName + "!");
                return user;
            } else {
                remainingAttempts--;
                if (remainingAttempts > 0) {
                    System.out.println("Incorrect Password! Please try again.");
                } else {
                    System.out.println("3 Incorrect Attempts! Your card has been blocked.");
                }
            }
        }
        return null;
    }
    public static void runAtmMenu(Scanner scanner, User user) {
        boolean isAtmRunning = true;
        while (isAtmRunning) {
            System.out.println("\nPlease Select an Operation:");
            System.out.println("1- Balance Inquiry\n2- Withdraw Money\n3- Deposit Money\n4- Exit");
            int choice = SafeInt(scanner);
            switch (choice) {
                case 1 :
                    System.out.println("Current Balance = " + user.balance + " TL");
                    break;
                case 2 :
                    withdrawMoney(scanner, user);
                    break;
                case 3 :
                    depositMoney(scanner, user);
                    break;
                case 4 :
                    System.out.println("Please take your card. Have a nice day");
                    isAtmRunning = false;
                    break;
                default:
                    System.out.println("Invalid Option! Please try again.");
            }
        }
    }
    public static void withdrawMoney(Scanner scanner, User user) {
        System.out.print("Enter Amount to Withdraw: ");
        int amount = SafeInt(scanner);
        if (amount > user.balance) {
            System.out.println("Insufficient Balance! Please try again.");
        } else {
            user.balance -= amount;
            System.out.println("New Balance = " + user.balance + " TL\nPlease take your cash.");
        }
    }
    public static void depositMoney(Scanner scanner, User user) {
        System.out.print("Enter Amount to Deposit: ");
        int amount = SafeInt(scanner);
        user.balance += amount;
        System.out.println("New Balance = " + user.balance + " TL");
    }
    public static int SafeInt(Scanner scanner) {
        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter numbers only! Letters are not allowed.");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("Error: Please enter a value greater than 0!");
            } else {
                isValid = true;
            }
        }
        return input;
    }
}