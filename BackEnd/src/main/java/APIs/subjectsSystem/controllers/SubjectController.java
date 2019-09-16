package APIs.subjectsSystem.controllers;

import APIs.subjectsSystem.entities.Subject;
import APIs.subjectsSystem.entities.SubjectInfo;
import APIs.subjectsSystem.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("v1/api/subjects")
    public ResponseEntity<Subject> postSubjects(@RequestBody SubjectInfo newSubjectInfo) {
        return new ResponseEntity<>(subjectService.createSubject(newSubjectInfo), HttpStatus.OK);
    }

    @GetMapping("v1/api/subjects")
    public ResponseEntity<Map<Integer, Subject>> getSubjects() {
        return new ResponseEntity<>(subjectService.getSubjectMap(), HttpStatus.OK);
    }

    @GetMapping("v1/api/subjects/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable("id") int id) {
        Subject subject = subjectService.getSubject(id);
        if (subject != null)
            return new ResponseEntity<>(subject, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO: Preciso ver como pegar um único atibuto do JSON
    /*
    @PutMapping("v1/api/subjects/{id}/name")
    public ResponseEntity<Subject> putSubjectName(@PathVariable("id") int id, @RequestBody String name) {
        Subject subject = subjectService.putSubjectName(id, name);
        if (subject != null)
            return new ResponseEntity<>(subject, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("v1/api/subjects/{id}/grade")
    public ResponseEntity<Subject> putSubjectGrade(@PathVariable("id") int id, @RequestAttribute double newGrade) {
        Subject subject = subjectService.putSubjectGrade(id, newGrade);
        if (subject != null)
            return new ResponseEntity<>(subject, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    */

    @DeleteMapping("v1/api/subjects/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable("id") int id) {
        Subject subject = subjectService.deleteSubject(id);
        if (subject != null)
            return new ResponseEntity<>(subject, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("v1/api/subjects/ranking")
    public ResponseEntity<List<Subject>> getSubjectsRanking() {
        return new ResponseEntity<>(subjectService.getSubjectsRanking(), HttpStatus.OK);
    }

}
