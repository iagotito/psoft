package auth.repositories;

import auth.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProductRepository <T, ID extends Serializable> extends JpaRepository<Product, Long> {
}
