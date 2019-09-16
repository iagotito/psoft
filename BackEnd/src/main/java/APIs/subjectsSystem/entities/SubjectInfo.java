package APIs.subjectsSystem.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SubjectInfo {

    private String name;
    private double grade;

    @JsonCreator
    public SubjectInfo (String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
