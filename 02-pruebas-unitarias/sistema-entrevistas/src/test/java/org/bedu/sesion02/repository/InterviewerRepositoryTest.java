package org.bedu.sesion02.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.bedu.sesion02.model.Interviewer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InterviewerRepositoryTest {

    private static InterviewerRepository repository;

    @BeforeAll
    public static void setup() {
        // Arrange: Exista una instancia del repositorio
        repository = new InterviewerRepository();
    }

    @AfterEach
    public void after() {
        repository.clear();
    }

    @Test
    @DisplayName("A new repository should be empty")
    public void emptyCase() {
        // Act: El código a probar
        int count = repository.count();

        // Assert: Comprobar el resultado esperado
        // La variable count debería ser 0
        assertEquals(0, count);
    }

    @Test
    @DisplayName("Repository should save an interviewer")
    public void saveCase() {
        String name = "Juan Perez";
        String email = "juan@bedu.org";

        Interviewer interviewer = repository.save(name, email);

        assertEquals(1, interviewer.getId());
        assertEquals(1, repository.count());
        assertEquals(name, interviewer.getName());
        assertEquals(email, interviewer.getEmail());
    }

    @Test
    @DisplayName("Repository should find an interviewer")
    public void findInterviewer() {
        // Arrange: Debe existir al menos un elemento en el repositorio
        String name = "Juan Perez";
        String email = "juan@bedu.org";

        repository.save(name, email);

        // Act
        Optional<Interviewer> result = repository.findByEmail(email);
        Interviewer interviewer = result.get();

        // Assert
        assertTrue(result.isPresent());
        assertNotNull(interviewer);
        assertEquals(name, interviewer.getName());
    }
}
