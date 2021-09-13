package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Repository {
  private final Clock clock;
  private List<Transaction> transactions = new ArrayList<>();

  public Repository(Clock clock) {
    this.clock = clock;
  }

  public void deposit(int amount) {
    transactions.add(new Transaction(amount, clock.getDate()));
  }

  public void withdraw(int amount) {
    transactions.add(new Transaction(-amount, clock.getDate()));
  }

  public List<Transaction> getTransactionList() {
    return this.transactions;
  }
}
