package auth.services;

import auth.entities.Product;
import auth.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private ProductsRepository<Product, Long> productsRepository;

    public ProductsService(ProductsRepository<Product, Long> productsRepository) {
        super();
        this.productsRepository = productsRepository;
    }

    public Product postProduct (Product product) {
        return productsRepository.save(product);
    }

    public Optional<Product> getProduct (long id) {
        return productsRepository.findById(id);
    }

    public List<Product> getProducts () {
        return productsRepository.findAll();
    }

    public Optional<Product> deleteProduct (long id) {
        Optional<Product> product = getProduct(id);
        productsRepository.deleteById(id);
        return product;
    }

}
