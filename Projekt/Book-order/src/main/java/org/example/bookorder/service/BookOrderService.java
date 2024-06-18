package org.example.bookorder.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.bookorder.communication.BookShopClient;
import org.example.bookorder.model.BookToOrderDetails;
import org.example.bookorder.model.Orders;
import org.example.bookorder.repository.OrdersRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class BookOrderService {

    private final BookShopClient bookShopClient;
    private final OrdersRepository ordersRepository;

    public BookOrderService(BookShopClient bookShopClient, OrdersRepository ordersRepository) {
        this.bookShopClient = bookShopClient;
        this.ordersRepository = ordersRepository;
    }

    public void checkAndPlaceOrder() {
        List<BookToOrderDetails> booksToOrder = bookShopClient.getBooksToOrder();

        if (booksToOrder.isEmpty()) {
            throw new RuntimeException("Lista booksToOrder jest pusta");
        }

        booksToOrder.forEach(book -> {
            Orders orders = new Orders();
            orders.setBook_id(book.getId());
            orders.setQuantity(Math.floorDiv(book.getViews(), 10));
            ordersRepository.save(orders);
        });
    }

    public ResponseEntity<byte[]> generateOrderPdf() {
        List<Orders> orders = ordersRepository.findAll();
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            document.add(new Paragraph("Orders List:"));

            for (Orders order : orders) {
                document.add(new Paragraph("Book ID: " + order.getBook_id() + ", Quantity to Order: " + order.getQuantity()));
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        byte[] pdfContent = byteArrayOutputStream.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=orders.pdf");
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
