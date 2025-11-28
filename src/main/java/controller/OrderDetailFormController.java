package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.pdf.PDFGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderDetailFormController {

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
    private TableView<?> tblOrderDetails;

    @FXML
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtProductId;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    void btnAddOnAction(ActionEvent event) {
//        GeneratePdf generatePdf = new GeneratePdf();
//        generatePdf.generateBill();
//
//
//        byte[] pdfBytes = PDFGenerator.generateInvoiceBytes();
//
//        if (pdfBytes != null) {
//            openPDF(pdfBytes); // optional
//        }
//
//
//    }
//
//    private void openPDF(byte[] pdfBytes) {
//        try {
//            java.io.File temp = java.io.File.createTempFile("clothify_bill_", ".pdf");
//            temp.deleteOnExit();
//
//            java.nio.file.Files.write(temp.toPath(), pdfBytes);
//
//            java.awt.Desktop.getDesktop().open(temp);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    }
}
