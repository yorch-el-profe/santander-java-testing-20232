package org.bedu.sesion02.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.bedu.sesion02.model.Interviewer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterviewerRepositoryTest {
  private static InterviewerRepository repository;

  @BeforeAll
  public static void setup() {
    repository = new InterviewerRepository();
  }

  @BeforeEach
  public void before() {
    repository.clear();
  }

  @Test
  @DisplayName("Repository should empty")
  public void emptyCase() {
    int count = repository.count();

    assertEquals(0, count);
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

  @Test
  @DisplayName("Repository should find an interviewer by email")
  public void findByEmailCase() {
    String name = "John Doe";
    String email = "john@mail.com";

    repository.save(name, email);

    Optional<Interviewer> result = repository.findByEmail(email);
    Interviewer interviewer = result.get();

    assertTrue(result.isPresent());
    assertNotNull(interviewer);
    assertEquals(email, interviewer.getEmail());
    assertEquals(name, interviewer.getName());
  }
}
