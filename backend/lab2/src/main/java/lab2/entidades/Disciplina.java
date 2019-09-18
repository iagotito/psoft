package lab2.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina implements Comparable<Disciplina> {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double nota;
    private String comentários;
    private int likes;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentários() {
        return comentários;
    }

    public void setComentários(String comentários) {
        this.comentários = comentários;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    @Override
    public int compareTo(Disciplina disciplina) {
        if (this.getNota() > disciplina.getNota())
            return -1;
        else if (this.getNota() < disciplina.getNota())
            return 1;
        else
            return 0;
    }
}
