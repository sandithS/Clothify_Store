package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.OrderDetail;
import service.OrderDetailService;
import service.impl.OrderDetailServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailFormController implements Initializable {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colProductId;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableView<OrderDetail> tblOrderDetails;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtTotal;

    OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        loadTable();
    }

    private void loadTable() {
        tblOrderDetails.setItems(orderDetailService.getAllOrderDetails());
    }
}
