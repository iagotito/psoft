package lab2.repositorios;

import lab2.entidades.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RepositorioDisciplinas<T, ID extends Serializable> extends JpaRepository<Disciplina, Long> {
}
