package lab2.entities;

public class SubjectDto_IdNameLikes {
    private long id;
    private String name;
    private int likes;

    public SubjectDto_IdNameLikes (long id, String name, int likes) {
        this.id = id;
        this.name = name;
        this.likes = likes;

    }

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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
