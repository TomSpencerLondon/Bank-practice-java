package com.codurance;

public class Account {
  private final Console console;
  private final Repository repository;

  public Account(Console console, Repository repository) {
    this.console = console;
    this.repository = repository;
  }

  public void deposit(int amount) {
    repository.deposit(amount);
  }

  public void withdraw(int amount) {
    repository.withdraw(amount);
  }

  public void printStatement() {
    console.printLine("DATE | AMOUNT | BALANCE");
  }
}
