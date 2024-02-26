package MusaPackage12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lapeng Bank Application");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        System.out.print("Enter account type (Regular/Interest/Checking/CD): ");
        String accountType = scanner.next();

        Account account = null;
        if ("Regular".equalsIgnoreCase(accountType)) {
            System.out.print("Enter minimum balance: ");
            double minimumBalance = scanner.nextDouble();

            System.out.print("Enter penalty: ");
            double penalty = scanner.nextDouble();

            account = new RegularAccount(name, balance, pin, minimumBalance, penalty);
        } else if ("Interest".equalsIgnoreCase(accountType)) {
            System.out.print("Enter yearly interest rate: ");
            double interest = scanner.nextDouble();

            account = new InterestAccount(name, balance, pin, interest);
        } else if ("Checking".equalsIgnoreCase(accountType)) {
            System.out.print("Enter minimum balance: ");
            double minimumBalance = scanner.nextDouble();

            System.out.print("Enter penalty: ");
            double penalty = scanner.nextDouble();

            System.out.print("Enter number of transactions: ");
            int transactions = scanner.nextInt();

            account = new CheckingAccount(name, balance, pin, minimumBalance, penalty, transactions);
        } else if ("CD".equalsIgnoreCase(accountType)) {
            System.out.print("Enter yearly interest rate: ");
            double interest = scanner.nextDouble();

            System.out.print("Enter penalty for early withdrawal: ");
            double penalty = scanner.nextDouble();

            System.out.print("Enter number of months: ");
            int months = scanner.nextInt();

            account = new CDAccount(name, balance, pin, interest, penalty, months);
        } else {
            System.out.println("Invalid account type.");
        }

        if (account != null) {
            System.out.println("Account created successfully!");
            boolean loggedIn = true;
            while (loggedIn) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                } else if (choice == 2) {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                } else if (choice == 3) {
                    System.out.println("Current balance: " + account.getBalance());
                } else if (choice == 4) {
                    loggedIn = false;
                    System.out.println("Thank you for using our services!");
                } else {
                    System.out.println("Invalid choice.");
                }
            }

        }
    }
}
