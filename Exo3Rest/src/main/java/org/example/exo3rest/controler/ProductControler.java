package org.example.exo3rest.controler;


import org.example.exo3rest.dto.ProductReceiveDTO;
import org.example.exo3rest.dto.ProductResponseDTO;
import org.example.exo3rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/catalog/product")
public class ProductControler {

private final ProductService productService;


    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

@GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(productService.getAllProducts());
}

@GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
}

@PostMapping
    public ResponseEntity<ProductResponseDTO> create (@RequestBody ProductReceiveDTO productReceiveDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productReceiveDTO));
}
@PutMapping("/{id}")
public ResponseEntity<ProductResponseDTO> update (@PathVariable Long id, @RequestBody ProductReceiveDTO productReceiveDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productReceiveDTO));
}

@DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
    productService.deleteProduct(id);
        return ResponseEntity.ok("product removed");
}





}

