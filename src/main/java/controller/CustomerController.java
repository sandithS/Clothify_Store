package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    CustomerService customerService = new CustomerServiceImpl();

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<Customer> tblCustomers;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPhoneNumber;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Customer customer = new Customer(
                txtCustomerId.getText(),
                txtName.getText(),
                txtPhoneNumber.getText(),
                txtEmail.getText()
        );

        customerService.addCustomerDetails(customer);

        loadTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerService.deleteCustomerDetails(txtCustomerId.getText());
        loadTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Customer customer = new Customer(
                txtCustomerId.getText(),
                txtName.getText(),
                txtPhoneNumber.getText(),
                txtEmail.getText()
        );

        customerService.updateCustomerDetails(customer);

        loadTable();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadTable();

        //---------------------------------------------------------------------------------------

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setSelectedValue(newValue);
            }
        });

    }

    private void setSelectedValue(Customer selectedValue) {

        txtCustomerId.setText(selectedValue.getId());
        txtName.setText(selectedValue.getName());
        txtPhoneNumber.setText(selectedValue.getPhoneNumber());
        txtEmail.setText(selectedValue.getEmail());

    }

    public void loadTable() {
        tblCustomers.setItems(customerService.getAllCustomerDetails());
    }
}
