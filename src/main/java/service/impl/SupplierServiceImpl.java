package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Supplier;
import repository.impl.SupplierRepositoryImpl;
import service.SupplierService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierServiceImpl implements SupplierService {

    SupplierRepositoryImpl supplierRepository = new SupplierRepositoryImpl();

    @Override
    public void addSupplier(Supplier supplier) {
        supplierRepository.addSupplier(supplier);
    }

    @Override
    public ObservableList<Supplier> getAllSuppliers() {
        ObservableList<Supplier> supplierObservableList = FXCollections.observableArrayList();

        ResultSet resultSet = supplierRepository.getAll();

        try {
            while (resultSet.next()) {
                Supplier item = new Supplier(
                        resultSet.getString("supplier_id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("address")
                );
                supplierObservableList.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplierObservableList;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierRepository.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(String supplierId) {
        supplierRepository.deleteSupplier(supplierId);
    }

    @Override
    public Supplier searchSupplier(String supplierId, String supplierName) {
        ResultSet resultSet = supplierRepository.searchSupplier(supplierId,supplierName);

        try {
            resultSet.next();
            return new Supplier(
                    resultSet.getString("supplier_id"),
                    resultSet.getString("name"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getString("address")
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
