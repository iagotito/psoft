package lab2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject implements Comparable<Subject> {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double grade;
    private String comments;
    private int likes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Subject (String name) {
        super();
        this.name = name;
        this.grade = 0;
        this.comments = "";
        this.likes = 0;
    }

    public Subject () {
        super();
    }

    @Override
    public int compareTo(Subject subject) {
        if (this.getGrade() > subject.getGrade())
            return -1;
        else if (this.getGrade() < subject.getGrade())
            return 1;
        else
            return 0;
    }
}
