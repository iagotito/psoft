package APIs.subjectsSystem.services;

import APIs.subjectsSystem.entities.Subject;
import APIs.subjectsSystem.entities.SubjectInfo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectService {

    private int counter;
    private Map<Integer, Subject> subjectMap;

    public SubjectService () {
        counter = 0;
        subjectMap = new HashMap<>();
    }

    public Subject createSubject(SubjectInfo SubjectInfo) {
        counter++;
        Subject newSubject = new Subject(counter, SubjectInfo);
        subjectMap.put(counter, newSubject);
        return newSubject;
    }

    public Map<Integer, Subject> getSubjectMap() {
        return subjectMap;
    }

    public Subject getSubject(int id) {
        return subjectMap.get(id);
    }

    /*
    public Subject putSubjectName(int id, String newName) {
        Subject subject = subjectMap.get(id);
        try {
            subject.setName(newName);
        } catch (NullPointerException ne) {
            return null;
        }
        return subject;
    }

    public Subject putSubjectGrade(int id, double newGrade) {
        Subject subject = subjectMap.get(id);
        try {
            subject.setGrade(newGrade);
        } catch (NullPointerException ne) {
            return null;
        }
        return subject;
    }
*/
    public Subject deleteSubject(int id) {
        Subject subject = subjectMap.get(id);
        if (subject != null)
            subjectMap.remove(id);
        return subject;
    }

    public List<Subject> getSubjectsRanking() {
        Map<Double, Subject> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (Integer id : subjectMap.keySet())
            treeMap.put(subjectMap.get(id).getGrade(), subjectMap.get(id));
        return new LinkedList<>(treeMap.values());
    }
}
