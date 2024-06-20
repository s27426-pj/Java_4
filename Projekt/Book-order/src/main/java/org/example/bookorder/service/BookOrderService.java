package org.example.bookorder.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import feign.Response;
import org.example.bookorder.communication.BookShopClient;
import org.example.bookorder.error.EmptyListException;
import org.example.bookorder.mapper.OrdersMapper;
import org.example.bookorder.model.BookToOrderDetails;
import org.example.bookorder.model.Orders;
import org.example.bookorder.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class BookOrderService {

    private final BookShopClient bookShopClient;
    private final OrdersMapper mapper;
    private final OrdersRepository ordersRepository;

    public BookOrderService(BookShopClient bookShopClient, OrdersMapper mapper, OrdersRepository ordersRepository) {
        this.bookShopClient = bookShopClient;
        this.mapper = mapper;
        this.ordersRepository = ordersRepository;
    }

    public void checkAndPlaceOrder() {
        List<Response> booksToOrderResponses = bookShopClient.getBooksToOrder();

        if (booksToOrderResponses.isEmpty()) {
            throw new EmptyListException("Lista booksToOrder jest pusta");
        }

        List<BookToOrderDetails> booksToOrder = booksToOrderResponses.stream()
                .map(mapper::toDetails)
                .toList();

        booksToOrder.forEach(book -> {
            Orders orders = new Orders();
            orders.setBook_id(book.getId());
            orders.setQuantity(Math.floorDiv(book.getViews(), 10));
            ordersRepository.save(orders);
        });
    }

    public byte[] generateOrderPdf() {
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

        return byteArrayOutputStream.toByteArray();
    }
}
