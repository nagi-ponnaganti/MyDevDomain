package com.nagihome.hfdp.ch14.builder;

public class BuilderMain {

    public static void main(String[] args) {

        BankAccount ba = new BankAccount.Builder()
                .setAccountNumber(468503L)
                .setBalance(433859.43)
                .setName("Nagi Ponnaganti").create();


    }
}
