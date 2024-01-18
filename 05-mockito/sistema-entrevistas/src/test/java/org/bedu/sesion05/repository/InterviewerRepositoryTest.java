package org.bedu.sesion05.repository;

import static org.bedu.sesion05.utils.SQLQueries.COUNT_INTERVIEWERS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InterviewerRepositoryTest {

    private InterviewerRepository repository;
    private Connection connectionMock;

    @BeforeEach
    public void setup() throws SQLException {
        connectionMock = Mockito.mock(Connection.class);
        repository = new InterviewerRepository(connectionMock);
    }

    @Test
    public void count() throws SQLException {
        Statement statementMock = Mockito.mock(Statement.class);
        ResultSet result = Mockito.mock(ResultSet.class);

        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(COUNT_INTERVIEWERS)).thenReturn(result);
        when(result.getInt("count")).thenReturn(10);

        int count = repository.count();

        assertEquals(10, count);
    }
}
