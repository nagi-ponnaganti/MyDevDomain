package com.nagihome.hfdp.ch14.builder;

public class BankAccount {

    private long accountNumber;
    private String name;
    private double balance;

    static class Builder {
        private long accountNumber;
        private String name;
        private double balance;

        public BankAccount create() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountNumber(this.accountNumber);
            bankAccount.setName(this.name);
            bankAccount.setBalance(this.balance);

            return bankAccount;
        }

        public Builder setAccountNumber(long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
