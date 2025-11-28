package repository;

import model.dto.Supplier;

import java.sql.ResultSet;

public interface SupplierRepository {

    ResultSet getAll();

    ResultSet searchSupplier(String supplierId, String sullpierName);

    void addSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void deleteSupplier(String supplierId);
}
