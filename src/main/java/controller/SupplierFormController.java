package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Supplier;
import service.SupplierService;
import service.impl.SupplierServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCategoryId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableView<Supplier> tblSuppliers;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCategoryId;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPhoneNumber;

    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    private JFXTextField txtSupplierName;

    SupplierService supplierService = new SupplierServiceImpl();

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                txtSupplierId.getText(),
                txtSupplierName.getText(),
                txtPhoneNumber.getText(),
                txtEmail.getText(),
                txtAddress.getText()
        );
        supplierService.addSupplier(supplier);
        loadTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        supplierService.deleteSupplier(txtSupplierId.getText());
        loadTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Supplier supplier = new Supplier(
                txtSupplierId.getText(),
                txtSupplierName.getText(),
                txtPhoneNumber.getText(),
                txtEmail.getText(),
                txtAddress.getText()
        );
        supplierService.updateSupplier(supplier);
        loadTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        loadTable();

        tblSuppliers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setSelectedValue(newValue);
            }
        });
    }

    private void setSelectedValue(Supplier selectedValue) {
        txtSupplierId.setText(selectedValue.getSupplierId());
        txtSupplierName.setText(selectedValue.getName());
        txtPhoneNumber.setText(selectedValue.getPhoneNumber());
        txtEmail.setText(String.valueOf(selectedValue.getEmail()));
        txtAddress.setText(String.valueOf(selectedValue.getAddress()));
    }

    private void loadTable() {
        tblSuppliers.setItems(supplierService.getAllSuppliers());
    }
}
