package org.bedu.sesion06.tdd.service;

import org.bedu.sesion06.tdd.dto.CreateInterviewerDTO;
import org.bedu.sesion06.tdd.dto.InterviewerDTO;
import org.bedu.sesion06.tdd.mapper.InterviewerMapper;
import org.bedu.sesion06.tdd.model.Interviewer;
import org.bedu.sesion06.tdd.repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewerService {

  @Autowired
  private InterviewerRepository repository;

  @Autowired
  private InterviewerMapper mapper;

  public InterviewerDTO save(CreateInterviewerDTO dto) {
    Interviewer model = mapper.toModel(dto);
    Interviewer result = repository.save(model);
    return mapper.toDTO(result);
  }
}
