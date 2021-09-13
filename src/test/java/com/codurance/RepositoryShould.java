package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class RepositoryShould {
  @Mock Clock clock;

  Repository repository;

  @BeforeEach
  void setUp() {
    repository = new Repository(clock);
  }

  @Test
  void saveTransactionWithDate() {
    given(clock.getDate()).willReturn("14/01/2012");

    repository.deposit(100);
    assertThat(repository.getTransactionList()).containsExactly(
        new Transaction(100, "14/01/2012")
    );
  }
}
