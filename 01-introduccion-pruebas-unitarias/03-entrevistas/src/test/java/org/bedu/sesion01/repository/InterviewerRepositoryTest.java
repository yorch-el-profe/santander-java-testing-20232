package org.bedu.sesion01.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterviewerRepositoryTest {
  private static InterviewerRepository repository;

  @BeforeAll
  public static void setup() {
    repository = new InterviewerRepository();
  }

  @Test
  @DisplayName("Repository should empty")
  public void emptyCase() {
    int count = repository.count();

    assertEquals(count, 0);
  }
}
