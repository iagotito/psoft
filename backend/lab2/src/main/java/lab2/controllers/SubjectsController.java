package lab2.controllers;

import lab2.entities.Subject;
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
    public ResponseEntity<Subject> postSubject (@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectsService.postSubject(subject), HttpStatus.CREATED);
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjects () {
        return new ResponseEntity<>(subjectsService.getSubjects(), HttpStatus.OK);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubject (@PathVariable long id) {
        Optional<Subject> subject = subjectsService.getSubject(id);
        if (subject.isPresent())
            return new ResponseEntity<>(subject.get(), HttpStatus.OK);
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

    @GetMapping("/subjects/ranking")
    public ResponseEntity<List<Subject>> subjectRanking () {
        return new ResponseEntity<>(subjectsService.subjectRanking(), HttpStatus.OK);
    }

}
