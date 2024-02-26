package MusaPackage12;

public class RegularAccount  extends Account{

        private double minimumBalance;
        private double penalty;

        public RegularAccount(String name, double balance, String pin, double minimumBalance, double penalty) {
            super(name, balance, pin);
            this.minimumBalance = minimumBalance;
            this.penalty = penalty;
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
//            if (balance - amount < minimumBalance) {
//                // Apply penalty
//                balance -= penalty;
//            } else {
//                balance -= amount;
//            }
//            System.out.println("Withdrawal successful. New balance: " + balance);

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
            }

            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + balance);
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
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

            return 0;
        }
    }

