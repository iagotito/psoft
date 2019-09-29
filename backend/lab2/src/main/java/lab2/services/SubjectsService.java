package lab2.services;

import lab2.entities.Subject;
import lab2.entities.SubjectDto_IdName;
import lab2.repositorys.SubjectsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectsService {

    private SubjectsRepository<Subject, Long> subjectsRepository;

    public SubjectsService(SubjectsRepository<Subject, Long> subjectsRepository) {
        super ();
        this.subjectsRepository = subjectsRepository;
    }

    public List<Subject> postSubjects (List<Subject> subjects) {
        for (Subject s : subjects)
            subjectsRepository.save(new Subject(s.getName()));
        return subjectsRepository.findAll();
    }

    public List<SubjectDto_IdName> getSubjects() {
        List<SubjectDto_IdName> subjectsDto = new ArrayList<>();
        List<Subject> subjects = subjectsRepository.findAll();
        for (Subject s : subjects)
            subjectsDto.add(new SubjectDto_IdName(s.getId(), s.getName()));
        return subjectsDto;
    }

    public Optional<Subject> getSubject (long id) {
        return subjectsRepository.findById(id);
    }

    public Optional<Subject> putSubjectName(long id, String name) {
        Optional<Subject> subject = subjectsRepository.findById(id);
        if (subject.isPresent())
            subject.get().setName(name);
        return subject;
    }

    public Optional<Subject> putSubjectGrade(long id, double grade) {
        Optional<Subject> subject = subjectsRepository.findById(id);
        if (subject.isPresent())
            subject.get().setGrade(grade);
        return subject;
    }

    public Optional<Subject> deleteSubject(long id) {
        Optional<Subject> subject = subjectsRepository.findById(id);
        if (subject.isPresent())
            subjectsRepository.deleteById(id);
        return subject;
    }

    public List<Subject> subjectRanking () {
        List<Subject> ranking = this.subjectsRepository.findAll();
        Collections.sort(ranking);
        return ranking;
    }

    public List<Subject> deleteAllSubjects() {
        List<Subject> subjects = subjectsRepository.findAll();
        subjectsRepository.deleteAll();
        return subjects;
    }
}
