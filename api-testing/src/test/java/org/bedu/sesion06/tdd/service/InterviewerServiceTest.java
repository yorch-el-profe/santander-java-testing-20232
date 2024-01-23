package org.bedu.sesion06.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import org.bedu.sesion06.tdd.dto.CreateInterviewerDTO;
import org.bedu.sesion06.tdd.dto.InterviewerDTO;
import org.bedu.sesion06.tdd.model.Interviewer;
import org.bedu.sesion06.tdd.repository.InterviewerRepository;
import org.hibernate.validator.cfg.defs.ru.INNDef;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InterviewerServiceTest {

  @Autowired
  private InterviewerService service;

  @MockBean
  private InterviewerRepository repository;

  @Test
  @DisplayName("Service should be injected")
  public void smoke() {
    assertNotNull(service);
  }

  @Test
  @DisplayName("Service should save an interviewer")
  public void save() {
    Interviewer fake = new Interviewer();
    
    fake.setId(1);
    fake.setName("John Doe");
    fake.setEmail("john.doe@test.com");

    when(repository.save(any())).thenReturn(fake);

    CreateInterviewerDTO dto = new CreateInterviewerDTO();

    dto.setName("John Doe");
    dto.setEmail("john.doe@test.com");

    InterviewerDTO result = service.save(dto);

    assertNotNull(result);
    assertEquals(dto.getName(), result.getName());
    assertEquals(dto.getEmail(), result.getEmail());
    assertTrue(result.getId() > 0);
  }

}
