package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProductController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField colCategoryId;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private JFXTextField colPrice;

    @FXML
    private TableColumn<?, ?> colProductId;

    @FXML
    private TableColumn<?, ?> colProductName;

    @FXML
    private JFXTextField colQuantity;

    @FXML
    private TableColumn<?, ?> colSku;

    @FXML
    private JFXTextField colSupplierId;

    @FXML
    private TableView<?> tblProducts;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtSku;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

}
