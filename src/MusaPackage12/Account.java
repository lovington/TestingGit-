package MusaPackage12;

public abstract class Account {

        protected String name;
        protected double balance;
        protected String pin;


        public Account(String name, double balance, String pin) {
            this.name = name;
            this.balance = balance;
            this.pin = pin;
        }
        int transaction;



        public abstract void deposit(double amount);
        public abstract void withdraw(double amount);
        public abstract double getBalance();
        public abstract String getName();
        public abstract boolean isValidPIN(String enteredPIN);
        public abstract double computeFees();
        public abstract double computeInterest();
    }

