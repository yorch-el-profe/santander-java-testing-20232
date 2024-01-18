package org.bedu.sesion05;

import java.sql.SQLException;
import java.util.Scanner;

import org.bedu.sesion05.repository.InterviewerRepository;

public class InterviewerSystem {

    private InterviewerRepository repository;
    private Scanner sc;

    public InterviewerSystem() throws SQLException {
        repository = new InterviewerRepository();
        sc = new Scanner(System.in);
    }

    public void start() throws SQLException {
        System.out.println("¡Bienvenido!");

        while (true) {
            System.out.println("\n¿Qué operación deseas realizar?");
            System.out.println("1. Cantidad de entrevistadores registrados");
            System.out.println("2. Registrar un nuevo entrevistador");
            System.out.println("3. Salir");

            int option = sc.nextInt();
            sc.nextLine();

            if (option == 3) {
                break;
            }

            switch (option) {
                case 1:
                    countInterviewers();
                    break;

                case 2:
                    addInterviewer();
                    break;

                default:
                    System.out.println("\nOpción inválida...");
            }
        }

        sc.close();
    }

    private void countInterviewers() throws SQLException {
        System.out.println("\nHay " + repository.count() + " entrevistadores registrados");
    }

    private void addInterviewer() throws SQLException {
        System.out.println("\nIngresa el nombre del entrevistador");

        String name = sc.nextLine();

        System.out.println("Ingresa el correo del entrevistador");

        String email = sc.nextLine();

        repository.save(name, email);
    }
}