package com.codurance;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import static com.google.common.collect.Lists.reverse;

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
    List<Transaction> transactions = repository.getTransactionList();

    AtomicInteger balance = new AtomicInteger(0);

    final List<String> collect = transactions
        .stream()
        .map(transaction -> statementLine(balance, transaction))
        .collect(Collectors.toList());

    reverse(collect).forEach(console::printLine);

  }

  private String statementLine(AtomicInteger balance, Transaction transaction) {
    return String.format("%s | %s", transaction.date, formatDecimal(transaction.amount)) +
        " | " +
        formatDecimal(balance.addAndGet(transaction.amount));
  }

  private String formatDecimal(int amount) {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    return decimalFormat.format(amount);
  }

}
