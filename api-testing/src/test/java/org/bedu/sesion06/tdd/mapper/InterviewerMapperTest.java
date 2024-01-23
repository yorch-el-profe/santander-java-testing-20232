package org.bedu.sesion06.tdd.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.bedu.sesion06.tdd.dto.CreateInterviewerDTO;
import org.bedu.sesion06.tdd.model.Interviewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InterviewerMapperTest {
  
  @Autowired
  private InterviewerMapper mapper;

  @Test
  @DisplayName("Mapper should be injected")
  public void smoke() {
    assertNotNull(mapper);
  }

  @Test
  @DisplayName("Mapper should convert from CreateInterviewerDTO to Interviewer model")
  public void fromCreateInterviewerDTOToInterviewer() {
    CreateInterviewerDTO dto = new CreateInterviewerDTO();
    dto.setName("John Doe");
    dto.setEmail("john.doe@test.com");

    Interviewer result = mapper.toModel(dto);

    assertNotNull(result);
    assertEquals(dto.getName(), result.getName());
    assertEquals(dto.getEmail(), result.getEmail());
  }
}
