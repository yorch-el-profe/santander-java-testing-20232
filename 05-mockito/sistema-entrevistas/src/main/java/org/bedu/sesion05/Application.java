package org.bedu.sesion05;

import java.sql.SQLException;

public class Application {
    public static void main(String... args) throws SQLException {
        InterviewerSystem system = new InterviewerSystem();

        system.start();
    }
}
