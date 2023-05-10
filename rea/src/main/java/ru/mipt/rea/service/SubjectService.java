package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.repos.SubjectRepo;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    public Subject save(SubjectDTO subjectDTO) {
        Subject subject = new Subject(subjectDTO.getName());
        return subjectRepo.save(subject);
    }

    public Subject findById(int id) {
        return subjectRepo.findById(id);
    }

    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

    public Subject findByName(String name) {
        return subjectRepo.findByName(name);
    }
}
