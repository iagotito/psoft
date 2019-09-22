package auth.controllers;

import auth.entities.Product;
import auth.services.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productsService.postProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct (@PathVariable long id) {
        Optional<Product> product = productsService.getProduct(id);
        if (product.isPresent())
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts () {
        return new ResponseEntity<>(productsService.getProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        Optional<Product> product = productsService.deleteProduct(id);
        if (product.isPresent())
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
