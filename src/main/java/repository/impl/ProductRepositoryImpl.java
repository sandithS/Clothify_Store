package repository.impl;

import db.DBConnection;
import model.dto.Product;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public ResultSet getAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet searchProduct(String productId, String productName) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE product_id = ? OR name = ?");
            preparedStatement.setObject(1,productId);
            preparedStatement.setObject(2,productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduct(Product product) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products VALUES(?,?,?,?,?,?)");

            preparedStatement.setObject(1, product.getProductId());
            preparedStatement.setObject(2, product.getName());
            preparedStatement.setObject(3, product.getDescription());
            preparedStatement.setObject(4, product.getPrice());
            preparedStatement.setObject(5, product.getSupplierId());
            preparedStatement.setObject(5, product.getQuantity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(String productId) {
        try {
            DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM products WHERE product_id='" + productId + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateProductQuantity(String productId, int quantity) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET quantity = quantity - ? WHERE product_id=?");

            preparedStatement.setObject(1, quantity);
            preparedStatement.setObject(2, productId);

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
