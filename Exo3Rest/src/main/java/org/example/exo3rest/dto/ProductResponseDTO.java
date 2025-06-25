package org.example.exo3rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductResponseDTO {


    private long id;

    private String name;
    private double price;

}
