package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CartItem;
import model.dto.Customer;
import model.dto.Order;
import model.dto.Product;
import service.PlaceOrderService;
import service.impl.PlaceOrderServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colProductId;

    @FXML
    private TableColumn<?, ?> colProductName;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableView<CartItem> tblCart;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtTotal;

    PlaceOrderService placeOrderService = new PlaceOrderServiceImpl();

    ObservableList<CartItem> cartItemObservableList = FXCollections.observableArrayList();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

        cartItemObservableList.add(new CartItem(
                txtProductId.getText(),
                txtProductName.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                calculateTotal(txtPrice.getText(),txtQuantity.getText())
        ));

        tblCart.setItems(cartItemObservableList);
        clearFields();
        calculateNetTotal();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws SQLException {
        placeOrderService.placeOrder(new Order(
                txtOrderId.getText(),
                String.valueOf(LocalDate.now()),
                txtCustomerId.getText()
        ),cartItemObservableList);
    }

    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {
        Customer customer = placeOrderService.getCustomer(txtCustomerId.getText());
        txtCustomerName.setText(customer.getName());
    }

    @FXML
    void txtProductIdOnAction(ActionEvent event) {
        Product product = placeOrderService.getProduct(txtProductId.getText());

        txtProductName.setText(product.getName());
        txtPrice.setText(String.valueOf(product.getPrice()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
    }

    private double calculateTotal(String unitPrice, String quantity){
        return Double.parseDouble(unitPrice) * Integer.parseInt(quantity);
    }

    public void clearFields(){
        txtProductId.setText(null);
        txtProductName.setText(null);
        txtPrice.setText(null);
        txtQuantity.setText(null);
    }

    public void calculateNetTotal(){
        double netTotal =0.0;
        for (CartItem cartItem: cartItemObservableList){
            netTotal += cartItem.getTotalPrice();
            txtTotal.setText(String.valueOf(netTotal));
        }
    }
}
