package org.example.exo3rest.controler;

import jakarta.servlet.http.HttpSession;
import org.example.exo3rest.dto.ProductResponseDTO;
import org.example.exo3rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cart/session")
public class CartSessionControler {

    private ProductService productService;
    private HttpSession session;

    public CartSessionControler(ProductService productService,HttpSession httpSession) {
        this.productService = productService;
        session = httpSession;
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<String> addToCart (@PathVariable long id){
        List<Long> itemId = (List<Long>) session.getAttribute("item");

        if(itemId == null){
            itemId = new ArrayList<>();
        }

        itemId.add(productService.getProductById(id).getId());

        session.setAttribute("item",itemId);
        return ResponseEntity.ok("item added to cart");
    }

    @GetMapping("/getitem")
    public ResponseEntity<List<ProductResponseDTO>> getItem (){
        List<Long> itemId = (List<Long>) session.getAttribute("item");
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();

        if(itemId != null){
            for (long id : itemId){
                productResponseDTOs.add(productService.getProductById(id));
            }
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
        }
        return ResponseEntity.ok(productResponseDTOs);
    }

    @DeleteMapping("/removefromcart/{id}")
    public ResponseEntity<String> removeFromCart (@PathVariable long id){
        List<Long> itemId = (List<Long>) session.getAttribute("item");

        if(itemId == null){
            itemId = new ArrayList<>();
        }

        itemId.remove(productService.getProductById(id).getId());

        session.setAttribute("item",itemId);
        return ResponseEntity.ok("item removed from cart");
    }



}
