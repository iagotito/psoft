package lab2.repositorys;

import lab2.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SubjectsRepository<T, ID extends Serializable> extends JpaRepository<Subject, Long> {
}
