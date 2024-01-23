package org.bedu.sesion06.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.bedu.sesion06.tdd.model.Interviewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class InterviewerRepositoryTest {
  
  @Autowired
  private InterviewerRepository repository;

  @Test
  @DisplayName("Repository should be injected")
  public void smoke() {
    assertNotNull(repository);
  }

  @Test
  @DisplayName("Repository should save an interviewer")
  public void save() {
    Interviewer interviewer = new Interviewer();

    interviewer.setName("John Doe");
    interviewer.setEmail("john.doe@test.com");

    Interviewer result = repository.save(interviewer);

    assertNotNull(result);
  }
}
