package org.bedu.sesion02.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Interviewer {

  private long id;
  private String name;
  private String email;
}
