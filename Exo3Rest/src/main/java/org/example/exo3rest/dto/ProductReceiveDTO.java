package org.example.exo3rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo3rest.entity.Product;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductReceiveDTO {

    private String name;
    private double price;



 public Product dtoToEntity() {
    return Product.builder().name(getName())
            .price(getPrice())
            .build();
}





}
