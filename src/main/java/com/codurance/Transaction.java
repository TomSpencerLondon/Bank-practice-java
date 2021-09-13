package com.codurance;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.text.DecimalFormat;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Transaction {
  int amount;
  String date;

  public Transaction(int amount, String date) {
    this.amount = amount;
    this.date = date;
  }

  @Override
  public boolean equals(Object other) {
    return reflectionEquals(this, other);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
}
