package vau.ac.lk.Assignment01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vau.ac.lk.Assignment01.model.Product;
import vau.ac.lk.Assignment01.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody Product product)
    {
        try{
            if(product.getQuantity()>0)
            {
                List<Product> products =  productService.addProduct(product);
                return ResponseEntity.status(HttpStatus.CREATED).body(products);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quantity must be greater than zero ");
            }
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts()
    {
        try{

                List<Product> products = productService.getAllProducts();
                return ResponseEntity.status(HttpStatus.OK).body(products);

        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal error");
        }
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        return "Successfully deleted";
    }
}
