package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Product;

public interface ProductService {

    void addProduct(Product product);

    ObservableList<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct(String productId);

    Product searchProduct(String productId, String productName);

    boolean updateProductQuantity(ObservableList<CartItem> cartItemObservableList);
}
