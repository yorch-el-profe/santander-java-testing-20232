package org.bedu.sesion02.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bedu.sesion02.model.Interviewer;

// Utilizaremos una arquitectura de n-capas para este proyecto.
// Para este punto el alumno debería estar familiarizado
// con el concepto de un repositorio.

// Nota: Un repositorio es una clase que permite acceder
// a la persistencia de datos a través de métodos.
// La persistencia puede ser en una base de datos,
// en un archivo o en lo que sea que almacene información.
// En este caso usaremos una lista.
public class InterviewerRepository {

  private List<Interviewer> data;

  // Llevamos el control interno del ID por medio de una variable
  private long currentId = 0;

  public InterviewerRepository() {
    data = new LinkedList<>();
  }

  // Este constructor permitirá facilitar las pruebas unitarias
  // para dar un estado inicial al repositorio
  public InterviewerRepository(List<Interviewer> data) {
    this.data = data;
  }

  public int count() {
    return data.size();
  }

  // Este método se tiene que implementar mientras se hacen las pruebas de "findByEmail"
  // como una necesidad de "resetear" la base de datos, es decir, usando @BeforeEach
  public void clear() {
    data.clear();
  }

  public Interviewer save(String name, String email) {
    Interviewer interviewer = Interviewer.builder()
        // Es ++currentId porque primero se incrementa en uno y
        // luego se asigna el valor
        .id(++currentId)
        .name(name)
        .email(email)
        .build();

    data.add(interviewer);

    return interviewer;
  }

  // Se prefiere el uso de streams
  public Optional<Interviewer> findByEmail(String email) {
    return data.stream().filter(interviewer -> interviewer.getEmail().equals(email)).findFirst();
  }
}
