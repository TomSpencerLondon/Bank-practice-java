package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Repository {
  private List<Transaction> transactions = new ArrayList<>();
  public void deposit(int amount) {
    transactions.add(new Transaction(amount));
  }
}
