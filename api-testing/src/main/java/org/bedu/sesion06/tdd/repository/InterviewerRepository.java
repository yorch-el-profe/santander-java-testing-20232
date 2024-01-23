package org.bedu.sesion06.tdd.repository;

import org.bedu.sesion06.tdd.model.Interviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepository extends CrudRepository<Interviewer, Long> {
  
}
