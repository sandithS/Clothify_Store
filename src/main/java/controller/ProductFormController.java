package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colCategoryId;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colProductId;

    @FXML
    private TableColumn<?, ?> colProductName;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colSku;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableView<Product> tblProducts;

    @FXML
    private JFXTextField txtCategoryId;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtSku;

    @FXML
    private JFXTextField txtSupplierId;

    ProductService productService = new ProductServiceImpl();

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Product product = new Product(
                txtProductId.getText(),
                txtProductName.getText(),
                txtDescription.getText(),
                txtSupplierId.getText(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtQuantity.getText())
        );
        productService.addProduct(product);
        loadTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        productService.deleteProduct(txtProductId.getText());
        loadTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Product product = new Product(
                txtProductId.getText(),
                txtProductName.getText(),
                txtDescription.getText(),
                txtSupplierId.getText(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtQuantity.getText())
        );
        productService.updateProduct(product);
        loadTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        loadTable();

        tblProducts.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                setSelectedValue(newValue);
            }
        });
    }

    private void setSelectedValue(Product selectedValue) {
        txtProductId.setText(selectedValue.getProductId());
        txtDescription.setText(selectedValue.getDescription());
        txtProductName.setText(selectedValue.getName());
        txtPrice.setText(String.valueOf(selectedValue.getPrice()));
        txtQuantity.setText(String.valueOf(selectedValue.getQuantity()));
    }

    private void loadTable() {
        tblProducts.setItems(productService.getAllProducts());
    }
}
