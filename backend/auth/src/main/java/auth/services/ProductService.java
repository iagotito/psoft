package auth.services;

import auth.entities.Product;
import auth.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository<Product, Long> productRepository;

    public ProductService (ProductRepository<Product, Long> productRepository) {
        super();
        this.productRepository = productRepository;
    }

    public Product postProduct (Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct (long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProducts () {
        return productRepository.findAll();
    }

    public Optional<Product> deleteProduct (long id) {
        Optional<Product> product = getProduct(id);
        productRepository.deleteById(id);
        return product;
    }

}
