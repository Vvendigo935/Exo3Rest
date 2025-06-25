package org.example.exo3rest.service;


import org.example.exo3rest.dto.ProductReceiveDTO;
import org.example.exo3rest.entity.Product;
import org.example.exo3rest.exeption.NotFoundException;
import org.example.exo3rest.dto.ProductResponseDTO;
import org.example.exo3rest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO create (ProductReceiveDTO productReceiveDTO) {
        return productRepository.save(productReceiveDTO.dtoToEntity()).entityToDTO();
    }

    public ProductResponseDTO getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(NotFoundException::new).entityToDTO();
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(Product::entityToDTO).toList();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductResponseDTO updateProduct(Long id, ProductReceiveDTO productReceiveDTO) {
        Product productFound = productRepository.findById(id).orElseThrow(NotFoundException::new);
        Product productGet = productReceiveDTO.dtoToEntity();
        productFound.setName(productGet.getName());
        productFound.setPrice(productGet.getPrice());

        return productRepository.save(productFound).entityToDTO();
    }

    public ProductResponseDTO addProductToCart(Long id) {
        productRepository.findById(id).orElseThrow(NotFoundException::new).entityToDTO();
        return productRepository.save(productRepository.findById(id).orElseThrow(NotFoundException::new)).entityToDTO();
    }





}

