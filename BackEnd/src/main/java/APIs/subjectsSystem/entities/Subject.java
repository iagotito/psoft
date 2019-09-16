package APIs.subjectsSystem.entities;

public class Subject extends SubjectInfo {

    private int id;

    public Subject (int id, String name, double grade) {
        super(name, grade);
        this.id = id;
    }

    public Subject (int id, SubjectInfo subjectInfo) {
        super (subjectInfo.getName(), subjectInfo.getGrade());
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
