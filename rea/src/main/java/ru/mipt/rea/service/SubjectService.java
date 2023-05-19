package ru.mipt.rea.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mipt.rea.dto.SubjectDTO;
import ru.mipt.rea.models.Subject;
import ru.mipt.rea.repos.SubjectRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {

    private final SubjectRepo subjectRepo;
    private final Convertor convertor;

    private Subject convertToEntity(SubjectDTO subjectDTO) {
        return convertor.convert(subjectDTO, Subject.class);
    }

    private SubjectDTO convertToDto(Subject subject) {
        return convertor.convert(subject, SubjectDTO.class);
    }

    private List<SubjectDTO> convertToDtoList(List<Subject> subjectList) {
        return convertor.convertList(subjectList, SubjectDTO.class);
    }
    public void save(SubjectDTO subjectDTO) {
        Subject subject = convertToEntity(subjectDTO);
        subjectRepo.save(subject);
    }

    public SubjectDTO findById(int id) {
        Subject subject = subjectRepo.findById(id);
        return convertToDto(subject);
    }

    public List<SubjectDTO> findAll() {
        List<Subject> subjectList = subjectRepo.findAll();
        return convertToDtoList(subjectList);
    }

    public SubjectDTO findByName(String name) {
        Subject subject = subjectRepo.findByName(name);
        return convertToDto(subject);
    }
}
