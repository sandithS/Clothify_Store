package repository;

import model.dto.Product;

import java.sql.ResultSet;

public interface ProductRepository {

    ResultSet getAll();

    ResultSet searchProduct(String productId, String productName);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(String productId);

    boolean updateProductQuantity(String productId, int quantity);
}
