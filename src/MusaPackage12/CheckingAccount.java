package MusaPackage12;

public class CheckingAccount extends Account{

        private double minimumBalance;
        private double penalty;
        private int transactions;

        public CheckingAccount(String name, double balance, String pin, double minimumBalance, double penalty, int transactions) {
            super(name, balance, pin);
            this.minimumBalance = minimumBalance;
            this.penalty = penalty;
            this.transactions = transactions;
        }

        @Override
        public void deposit(double amount) {

            double transactionAmount = transaction;
            transactionAmount = 0.1;
            balance -= transactionAmount;
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        }

        @Override
        public void withdraw(double amount) {

            double transactionAmount = transaction;
            transactionAmount = 0.1;
            balance -= transactionAmount;

            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
                return;
            }

            if (balance - amount < minimumBalance) {
                // Apply penalty
                balance -= penalty;
            } else {
                balance -= amount;
            }
            transactions++; // Increment transaction count
            System.out.println("Withdrawal successful. New balance: " + balance);
        }

        @Override
        public double getBalance() {
            return balance;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean isValidPIN(String enteredPIN) {
            return pin.equals(enteredPIN);
        }

        @Override
        public double computeFees() {
            return Math.min(10, 0.1 * balance) + (transactions * 0.1);
        }

        @Override
        public double computeInterest() {
            return balance * (7 / 100) / 12; // Monthly interest
        }
    }

