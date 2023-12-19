package org.bedu.sesion01.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bedu.sesion01.model.Interviewer;
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

  @Test
  @DisplayName("Repository should add an interviewer")
  public void addInterviewerCase() {
    String name = "Juan Perez";
    String email = "juan@mail.com";
    
    Interviewer saved = repository.save(name, email);

    assertEquals(1, saved.getId());
    assertEquals(name, saved.getName());
    assertEquals(email, saved.getEmail());
    assertEquals(1, repository.count());
  }
}
