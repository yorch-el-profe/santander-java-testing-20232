package org.bedu.sesion05.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bedu.sesion05.model.Interviewer;
import static org.bedu.sesion05.utils.SQLQueries.*;

public class InterviewerRepository {
    Connection connection;

    public InterviewerRepository(Connection connection) {
        this.connection = connection;
    }

    public InterviewerRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/interviewers.db");
        createTable();
    }

    private void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "CREATE TABLE interviewers (id integer PRIMARY KEY AUTOINCREMENT, name string, email string)");
    }

    public Interviewer save(String name, String email) throws SQLException {
        String sql = "INSERT INTO interviewers VALUES (0, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);

        statement.executeUpdate();

        sql = "SELECT MAX(id) AS max_id FROM interviewers";
        Statement statement2 = connection.createStatement();
        ResultSet result = statement2.executeQuery(sql);

        result.next();
        long id = result.getLong("max_id");

        return new Interviewer(id, name, email);
    }

    public int count() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(COUNT_INTERVIEWERS);

        result.next();
        return result.getInt("count");
    }
}
