package controller.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Order;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

public class PDFGenerator {

    public static byte[] generateInvoiceBytes(Order order, ObservableList<CartItem> cartItemObservableList) {

        int netTotal = 0;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("***************************************************"));
            document.add(new Paragraph("                    C A S H   R E C I E P T"));
            document.add(new Paragraph("                            Shop Name"));
            document.add(new Paragraph("                    Address: Zip Code, City"));
            document.add(new Paragraph("***************************************************"));
            document.add(new Paragraph("Order Id: "+order.getOrderID()));
            document.add(new Paragraph("Customer Id: "+order.getCustomerID()));
            document.add(new Paragraph("Date: " + LocalDate.now()));
            document.add(new Paragraph("----------------------------------------------------"));

            // Items list (dynamic or static)
            for (CartItem cartItem: cartItemObservableList){
                document.add(new Paragraph(cartItem.getQuantity()+"x"+cartItem.getProductName()+"    "+cartItem.getTotalPrice()));
                netTotal += cartItem.getTotalPrice();
            }
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph("================================"));
            document.add(new Paragraph("TOTAL AMOUNT                        "+netTotal));
            document.add(new Paragraph("***************************************************"));
            document.add(new Paragraph("\n                    THANK YOU!"));
            document.close();

            return baos.toByteArray(); // <-- YOUR PDF IN MEMORY

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
