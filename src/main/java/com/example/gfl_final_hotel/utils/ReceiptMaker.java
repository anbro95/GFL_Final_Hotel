package com.example.gfl_final_hotel.utils;

import com.example.gfl_final_hotel.model.Booking;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class ReceiptMaker {

    public static void createReceipt(Booking booking) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream stream;
        try {
            stream = new PDPageContentStream(document, page);
            stream.setFont(PDType1Font.COURIER, 14);
            stream.beginText();
            stream.newLineAtOffset(50, 700); // Set the starting position of the text

            stream.showText(" Booking " + booking.getId());
            stream.newLineAtOffset(0, -20); // Move to the next line
            stream.showText(" Guest: " + booking.getGuest().getFirstName() + " " + booking.getGuest().getLastName());
            stream.newLineAtOffset(0, -20); // Move to the next line
            stream.showText(" Room: " + booking.getRoom().getId());
            stream.newLineAtOffset(0, -20); // Move to the next line
            stream.showText(" Booking starts: " + booking.getDayFrom());
            stream.newLineAtOffset(0, -20); // Move to the next line
            stream.showText(" Booking ends: " + booking.getDayTo());
            stream.newLineAtOffset(0, -20); // Move to the next line
            stream.showText(" Total sum: " + booking.getSum());

            stream.endText();
            stream.close();
            document.save("receipt.pdf");
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
