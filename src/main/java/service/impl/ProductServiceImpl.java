package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Product;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {

    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public ObservableList<Product> getAllProducts() {
        ObservableList<Product> productObservableList = FXCollections.observableArrayList();

        ResultSet resultSet = productRepository.getAll();

        try {
            while (resultSet.next()) {
                Product item = new Product(
                        resultSet.getString("product_id"),
                        resultSet.getString("sku"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity")
                );
                productObservableList.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productObservableList;
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteProduct(productId);
    }

    @Override
    public Product searchProduct(String productId, String productName) {
        ResultSet resultSet = productRepository.searchProduct(productId,productName);

        try {
            resultSet.next();
            return new Product(
                    resultSet.getString("product_id"),
                    resultSet.getString("sku"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("quantity")
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateProductQuantity(ObservableList<CartItem> cartItemObservableList) {
        boolean isItemQtyUpdate = false;

        for (CartItem cartItem:cartItemObservableList){
            isItemQtyUpdate = productRepository.updateProductQuantity(cartItem.getProductId(),cartItem.getQuantity());
        }
        if (isItemQtyUpdate == false){
            return false;
        }
        return isItemQtyUpdate;
    }
}
