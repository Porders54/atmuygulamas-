import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 10000 ;
        boolean isAtmRunning = true;
        int correctPassword = 1234 ;
        boolean isLoginSuccessful = false;
        int remainingAttempts = 3;
        System.out.println("Welcome to Deka Bank");
        while (!isLoginSuccessful && remainingAttempts > 0 ) {
            System.out.println("Please Enter Your Password = " + remainingAttempts);
            int enterPassword = SafeInt(scanner);
            if (enterPassword == correctPassword) {
                System.out.println("Password Correct, Logging in");
                isLoginSuccessful = true;
            } else {
                remainingAttempts = remainingAttempts - 1;
                if (remainingAttempts > 0) {
                    System.out.println("Incorrect Password, Please Try Again");
                } else {
                    System.out.println("3 Incorrect Attempts! Your Card Has Been Blocked");
                }

            }
        }
        if (isLoginSuccessful) {
            while (isAtmRunning) {
                System.out.println("Please Select an Operation");
                System.out.println("1- Balance Inquiry");
                System.out.println("2- Withdraw Money");
                System.out.println("3- Deposit Money");
                System.out.println("4- Exit");
                int choice = SafeInt(scanner);
                switch (choice) {
                    case 1:
                        System.out.println("Current Balance  = " + balance + "TL" );
                        break;
                    case 2:
                        System.out.println("Enter Amount to Withdraw");
                        int withdrawAmount = SafeInt(scanner);
                        if (withdrawAmount>balance)  {
                            System.out.println("Insufficient Balance. Please try again");
                        } else {
                            balance = balance - withdrawAmount;
                            System.out.println("New Balance = " +  balance + "TL");
                            System.out.println("Please take your cash");
                        } break;
                    case 3:
                        System.out.println("Enter Amount to Deposit");
                        int depositAmount = SafeInt(scanner);
                        balance = balance + depositAmount;
                        System.out.println("New Balance = " + balance + "TL");
                        break;
                    case 4:
                        System.out.println("Please take your card");
                        isAtmRunning = false;
                        break;
                    default:
                        System.out.println("Invalid Option, Please Try Again");
                }
            }
        } else {
            System.out.println("Login failed. Unable to connect to ATM services");
        }
    }
    public static int SafeInt(Scanner scanner) {
        int input = -1 ;
        boolean isValid = false;
        while (!isValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter numbers only, letters are not allowed");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("Error: Please enter a value greater than 0");
            } else {
                isValid = true;
            }
        }
        return input;
    }
}