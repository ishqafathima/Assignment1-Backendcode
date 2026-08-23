package vau.ac.lk.Assignment01.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vau.ac.lk.Assignment01.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();
    public ProductService()
    {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("PC");
        product1.setPrice(10000);
        product1.setQuantity(20);

        products.add(product1);
    }

    public List<Product> addProduct(Product product)
    {
        try
        {
            products.add(product);
            return products;
        }
        catch(Exception e)
        {
            throw new RuntimeException("Internal Error");
        }
    }


    public List<Product> getAllProducts()
    {
        try
        {
            if(products.isEmpty())
            {
                throw new RuntimeException("No products Found");
            }else {
                return products;
            }

        }
        catch(Exception e)
        {
            throw new RuntimeException("Internal Error");
        }
    }
    public void deleteProduct(Product product) {
        products.remove(product);
    }

}
