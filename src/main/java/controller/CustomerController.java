package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<?> tblCustomers;

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

    }

}
