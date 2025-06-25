package org.example.exo3rest.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo3rest.dto.ProductResponseDTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;

    public ProductResponseDTO entityToDTO() {
        return ProductResponseDTO.builder()
                .id(getId())
                .name(getName())
                .price(getPrice())
                .build();
    }

}
