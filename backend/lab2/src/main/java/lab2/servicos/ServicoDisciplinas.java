package lab2.servicos;

import lab2.entidades.Disciplina;
import lab2.repositorios.RepositorioDisciplinas;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoDisciplinas {

    private RepositorioDisciplinas<Disciplina, Long> disciplinasDAO;

    public ServicoDisciplinas (RepositorioDisciplinas<Disciplina, Long> disciplinasDAO) {
        super ();
        this.disciplinasDAO = disciplinasDAO;
    }

    public Disciplina adicionaDisciplina (Disciplina disciplina) {
        return disciplinasDAO.save(disciplina);
    }

    public List<Disciplina> pegaDisciplinas() {
        return disciplinasDAO.findAll();
    }

    public Optional<Disciplina> pegaDisciplina (long id) {
        return disciplinasDAO.findById(id);
    }

    public Optional<Disciplina> atualizaNome(long id, String nome) {
        Optional<Disciplina> disciplina = disciplinasDAO.findById(id);
        if (disciplina.isPresent())
            disciplina.get().setNome(nome);
        return disciplina;
    }

    public Optional<Disciplina> atualizaNota(long id, double nota) {
        Optional<Disciplina> disciplina = disciplinasDAO.findById(id);
        if (disciplina.isPresent())
            disciplina.get().setNota(nota);
        return disciplina;
    }

    public Optional<Disciplina> removeDisciplina(long id) {
        Optional<Disciplina> disciplina = disciplinasDAO.findById(id);
        if (disciplina.isPresent())
            disciplinasDAO.deleteById(id);
        return disciplina;
    }

    public List<Disciplina> ranking () {
        List<Disciplina> ranking = this.disciplinasDAO.findAll();
        Collections.sort(ranking);
        return ranking;
    }
}
