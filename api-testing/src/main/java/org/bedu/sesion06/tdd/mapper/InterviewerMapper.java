package org.bedu.sesion06.tdd.mapper;

import org.bedu.sesion06.tdd.dto.CreateInterviewerDTO;
import org.bedu.sesion06.tdd.dto.InterviewerDTO;
import org.bedu.sesion06.tdd.model.Interviewer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InterviewerMapper {
  
  InterviewerDTO toDTO(Interviewer model);

  @Mapping(target = "id", ignore = true)
  Interviewer toModel(CreateInterviewerDTO dto);
}
