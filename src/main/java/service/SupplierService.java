package service;

import javafx.collections.ObservableList;
import model.dto.Supplier;

public interface SupplierService {

    void addSupplier(Supplier supplier);

    ObservableList<Supplier> getAllSuppliers();

    void updateSupplier(Supplier supplier);

    void deleteSupplier(String supplierId);

    Supplier searchSupplier(String supplierId, String supplierName);
}
