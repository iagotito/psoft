package lab2.services;

import lab2.entities.Subject;
import lab2.repositorys.SubjectsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectsService {

    private SubjectsRepository<Subject, Long> subjectsrRepository;

    public SubjectsService(SubjectsRepository<Subject, Long> subjectsrRepository) {
        super ();
        this.subjectsrRepository = subjectsrRepository;
    }

    public Subject postSubject (Subject subject) {
        return subjectsrRepository.save(subject);
    }

    public List<Subject> getSubjects() {
        return subjectsrRepository.findAll();
    }

    public Optional<Subject> getSubject (long id) {
        return subjectsrRepository.findById(id);
    }

    public Optional<Subject> putSubjectName(long id, String name) {
        Optional<Subject> subject = subjectsrRepository.findById(id);
        if (subject.isPresent())
            subject.get().setName(name);
        return subject;
    }

    public Optional<Subject> putSubjectGrade(long id, double grade) {
        Optional<Subject> subject = subjectsrRepository.findById(id);
        if (subject.isPresent())
            subject.get().setGrade(grade);
        return subject;
    }

    public Optional<Subject> deleteSubject(long id) {
        Optional<Subject> subject = subjectsrRepository.findById(id);
        if (subject.isPresent())
            subjectsrRepository.deleteById(id);
        return subject;
    }

    public List<Subject> subjectRanking () {
        List<Subject> ranking = this.subjectsrRepository.findAll();
        Collections.sort(ranking);
        return ranking;
    }
}
