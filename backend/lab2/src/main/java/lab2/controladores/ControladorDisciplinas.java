package lab2.controladores;

import lab2.entidades.Disciplina;
import lab2.servicos.ServicoDisciplinas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorDisciplinas {

    private ServicoDisciplinas servicoDisciplinas;

    public ControladorDisciplinas (ServicoDisciplinas servicoDisciplinas) {
        super ();
        this.servicoDisciplinas = servicoDisciplinas;
    }

    @PostMapping("/disciplinas")
    public ResponseEntity<Disciplina> adicionaDisciplina (@RequestBody Disciplina disciplina) {
        return new ResponseEntity<>(servicoDisciplinas.adicionaDisciplina(disciplina), HttpStatus.CREATED);
    }

    @GetMapping("/disciplinas")
    public ResponseEntity<List<Disciplina>> pegaDisciplinas () {
        return new ResponseEntity<>(servicoDisciplinas.pegaDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<Disciplina> pegaDisciplina (@PathVariable long id) {
        Optional<Disciplina> disciplina = servicoDisciplinas.pegaDisciplina(id);
        if (disciplina.isPresent())
            return new ResponseEntity<>(disciplina.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> atualizaNome (@PathVariable long id, @RequestBody Disciplina disciplinaInfo) {
        Optional<Disciplina> disciplina = servicoDisciplinas.atualizaNome(id, disciplinaInfo.getNome());
        if (disciplina.isPresent())
            return new ResponseEntity<>(disciplina.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> atualizaNota (@PathVariable long id, @RequestBody Disciplina disciplinaInfo) {
        Optional<Disciplina> disciplina = servicoDisciplinas.atualizaNota(id, disciplinaInfo.getNota());
        if (disciplina.isPresent())
            return new ResponseEntity<>(disciplina.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/disciplinas/{id}")
    public ResponseEntity<Disciplina> removeDisciplina (@PathVariable long id) {
        Optional<Disciplina> disciplina = servicoDisciplinas.removeDisciplina(id);
        if (disciplina.isPresent())
            return new ResponseEntity<>(disciplina.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/disciplinas/ranking")
    public ResponseEntity<List<Disciplina>> rankingDisciplina () {
        return new ResponseEntity<>(servicoDisciplinas.ranking(), HttpStatus.OK);
    }

}
