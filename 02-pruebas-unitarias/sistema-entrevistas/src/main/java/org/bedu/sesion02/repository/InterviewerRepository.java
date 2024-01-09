package org.bedu.sesion02.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bedu.sesion02.model.Interviewer;

public class InterviewerRepository {

    private List<Interviewer> data;
    private long currentId = 0;

    public InterviewerRepository() {
        data = new LinkedList<>();
    }

    public void clear() {
        data.clear();
    }

    public int count() {
        return data.size();
    }

    public Interviewer save(String name, String email) {
        Interviewer interviewer = Interviewer
                .builder()
                .name(name)
                .email(email)
                .id(++currentId)
                .build();

        data.add(interviewer);

        return interviewer;
    }

    public Optional<Interviewer> findByEmail(String email) {
        return data.stream().filter(x -> x.getEmail().equals(email)).findFirst();
    }
}
