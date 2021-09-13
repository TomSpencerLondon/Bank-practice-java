package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould {
  @Mock Repository repository;
  @Mock Console console;

  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account(console, repository);
  }

  @Test
  void deposits_1000() {
    account.deposit(1000);
    verify(repository).deposit(1000);
  }
}
