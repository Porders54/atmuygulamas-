import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 10000 ;
        boolean isAtmRunning = true;
        int correctPassword = 1234 ;
        boolean isLoginSuccessful = false;
        int remaningAttempts = 3;
        System.out.println("Welcom to Deka Bank");
        while (isLoginSuccessful == false && remaningAttempts > 0 ) {
            System.out.println("Pleas Enter Your Password = " + remaningAttempts);
            int enterPassword = scanner.nextInt();
            if (enterPassword == correctPassword) {
                System.out.println("Password Correct, Logging in");
                isLoginSuccessful = true;
            } else {
                remaningAttempts = remaningAttempts - 1;
                if (remaningAttempts > 0) {
                    System.out.println("Incorrect Password, Pleas Try Again");
                } else {
                    System.out.println("3 Incorrect Attempts! Your Card Has Been Blocked");
                }

            }
        }
        if (isLoginSuccessful) {
            while (isAtmRunning) {
                System.out.println("Pleas Select an Operation");
                System.out.println("1- Balance Inquiry");
                System.out.println("2- Withdraw Money");
                System.out.println("3- Deposit Money");
                System.out.println("4- Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Current Balance +   = " + balance + "TL" );
                        break;
                    case 2:
                        System.out.println("Enter Amount to Withdraw");
                        int withdrawAmount = scanner.nextInt();
                        if (withdrawAmount>balance)  {
                            System.out.println("Insufficient Balance. Please try again");
                        } else {
                            balance = balance - withdrawAmount;
                            System.out.println("New Balance = " +  balance + "TL");
                            System.out.println("Please take your cash");
                        } break;
                    case 3:
                        System.out.println("Enter Amount to Deposit");
                        int depositAmount = scanner.nextInt();
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
}
