package lab2.controllers;

import lab2.entities.Subject;
import lab2.entities.SubjectDto_IdName;
import lab2.entities.SubjectDto_IdNameLikes;
import lab2.services.SubjectsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectsController {

    private SubjectsService subjectsService;

    public SubjectsController(SubjectsService subjectsService) {
        super ();
        this.subjectsService = subjectsService;
    }

    @PostMapping("/subjects")
    public ResponseEntity<List<Subject>> postSubjects (@RequestBody List<Subject> subject) {
        return new ResponseEntity<>(subjectsService.postSubjects(subject), HttpStatus.CREATED);
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<SubjectDto_IdName>> getSubjects () {
        return new ResponseEntity<>(subjectsService.getSubjects(), HttpStatus.OK);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<SubjectDto_IdNameLikes> getSubject (@PathVariable long id) {
        Optional<Subject> subject = subjectsService.getSubject(id);
        if (subject.isPresent())
            return new ResponseEntity<>(new SubjectDto_IdNameLikes(
                    subject.get().getId(), subject.get().getName(), subject.get().getLikes()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/subjects/{id}/name")
    public ResponseEntity<Subject> putSubjectName (@PathVariable long id, @RequestBody Subject subjectInfo) {
        Optional<Subject> subject = subjectsService.putSubjectName(id, subjectInfo.getName());
        if (subject.isPresent())
            return new ResponseEntity<>(subject.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/subjects/{id}/grade")
    public ResponseEntity<Subject> putSubjectGrade (@PathVariable long id, @RequestBody Subject subjectInfo) {
        Optional<Subject> subject = subjectsService.putSubjectGrade(id, subjectInfo.getGrade());
        if (subject.isPresent())
            return new ResponseEntity<>(subject.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Subject> deleteSubject (@PathVariable long id) {
        Optional<Subject> subject = subjectsService.deleteSubject(id);
        if (subject.isPresent())
            return new ResponseEntity<>(subject.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/subjects/all")
    public ResponseEntity<List<Subject>> deleteAllSubjects () {
        return new ResponseEntity(subjectsService.deleteAllSubjects(), HttpStatus.OK);
    }

    @GetMapping("/subjects/ranking")
    public ResponseEntity<List<Subject>> subjectRanking () {
        return new ResponseEntity<>(subjectsService.subjectRanking(), HttpStatus.OK);
    }

}
