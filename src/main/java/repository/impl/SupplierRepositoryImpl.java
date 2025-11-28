package repository.impl;

import db.DBConnection;
import model.dto.Supplier;
import repository.SupplierRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierRepositoryImpl implements SupplierRepository {
    @Override
    public ResultSet getAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM suppliers");
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet searchSupplier(String supplierId, String sullpierName) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM suppliers WHERE supplier_id = ? OR name = ?");
            preparedStatement.setObject(1,supplierId);
            preparedStatement.setObject(2,sullpierName);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSupplier(Supplier supplier) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO suppliers VALUES(?,?,?,?,?,?)");

            preparedStatement.setObject(1, supplier.getSupplierId());
            preparedStatement.setObject(3, supplier.getName());
            preparedStatement.setObject(4, supplier.getPhoneNumber());
            preparedStatement.setObject(5, supplier.getEmail());
            preparedStatement.setObject(6, supplier.getAddress());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE suppliers SET category_id=?, name=?, phone=?, email=?, address=? WHERE supplier_id=?");

           // preparedStatement.setObject(1, supplier.getName());
            preparedStatement.setObject(2, supplier.getName());
            preparedStatement.setObject(3, supplier.getPhoneNumber());
            preparedStatement.setObject(4, supplier.getEmail());
            preparedStatement.setObject(5, supplier.getAddress());
            preparedStatement.setObject(6, supplier.getSupplierId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSupplier(String supplierId) {
        try {
            DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM suppliers WHERE supplier_id='" + supplierId + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
