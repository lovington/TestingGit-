package MusaPackage12;

public class CDAccount extends Account{

        private double interest;
        private double penalty;
        private int months;

        public CDAccount(String name, double balance, String pin, double interest, double penalty, int months) {
            super(name, balance, pin);
            this.interest = interest;
            this.penalty = penalty;
            this.months = months;
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

            if (months < 12) {
                // Apply penalty for early withdrawal
                balance -= balance * penalty;
            } else {
                balance -= amount;
            }
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
            return Math.min(10, 0.1 * balance);
        }

        @Override
        public double computeInterest() {
            return balance * (interest / 100);
        }
    }
