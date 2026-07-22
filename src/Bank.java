import java.util.Scanner;

public class Bank {
    public static int SafeInt(Scanner scanner) {
        int input = -1;
        boolean isValid = false;
        while (!isValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter numbers only! Letters are not allowed");
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
    public static User loginSystem(Scanner scanner, User user) {
        int remainingAttempts = 3;
        while (remainingAttempts > 0) {
            System.out.print("Please Enter Your Password (Attempts Left: " + remainingAttempts + "): ");
            int enterPassword = SafeInt(scanner);

            if (enterPassword == user.getPassword()) {
                System.out.println("Password Correct. Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
                return user;
            } else {
                remainingAttempts--;
                if (remainingAttempts > 0) {
                    System.out.println("Incorrect Password! Please try again");
                }
            }
        }
        return null;
    }
    public static void runAtmMenu(Scanner scanner, User user) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nPlease Select an Operation:");
            System.out.println("1- Balance Inquiry\n2- Withdraw Money\n3- Deposit Money\n4- Exit");
            int choice = SafeInt(scanner);
            switch (choice) {
                case 1:
                    System.out.println("Your current balance: " + user.getBalance() + " TL");
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = SafeInt(scanner);
                    if (withdrawAmount > user.getBalance()) {
                        System.out.println("Error: Insufficient funds");
                    } else {
                        user.setBalance(user.getBalance() - withdrawAmount);
                        System.out.println("Transaction successful. New Balance: " + user.getBalance() + " TL");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = SafeInt(scanner);
                    user.setBalance(user.getBalance() + depositAmount);
                    System.out.println("Transaction successful. New Balance: " + user.getBalance() + " TL");
                    break;
                case 4:
                    System.out.println("Thank you for using Deka Bank. Goodbye");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option! Please select between 1-4");
            }
        }
    }
}