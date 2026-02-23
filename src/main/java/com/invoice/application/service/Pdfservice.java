package com.invoice.application.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.invoice.application.entity.Invoice;
import com.invoice.application.entity.InvoiceItems;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;



@Service
public class Pdfservice {

    public byte[] generatepdf(Invoice invoice) throws Exception {

    Document document = new Document(PageSize.A4);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    PdfWriter.getInstance(document, out);
    document.open();

    // 🔹 Fonts
    Font titleFont = new Font(Font.HELVETICA, 22, Font.BOLD);
    Font companyFont = new Font(Font.HELVETICA, 18, Font.BOLD);
    Font normalFont = new Font(Font.HELVETICA, 12);
    Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);

    // 🔹 INVOICE Title
    Paragraph invoiceTitle = new Paragraph("INVOICE", titleFont);
    invoiceTitle.setAlignment(Element.ALIGN_CENTER);
    invoiceTitle.setSpacingAfter(10);
    document.add(invoiceTitle);

    // 🔹 Company Name (Centered + Bigger)
    Paragraph companyName = new Paragraph(invoice.getCompanyName(), companyFont);
    companyName.setAlignment(Element.ALIGN_CENTER);
    companyName.setSpacingAfter(20);
    document.add(companyName);

    // 🔹 Date
    Paragraph date = new Paragraph("Date: " + invoice.getCreatedAT(), normalFont);
    date.setSpacingAfter(20);
    document.add(date);

    // 🔹 Table
    PdfPTable table = new PdfPTable(4);
    table.setWidthPercentage(100);
    table.setSpacingBefore(10f);
    table.setSpacingAfter(10f);

    // Table Header Styling
    PdfPCell h1 = new PdfPCell(new Phrase("Product", headerFont));
    PdfPCell h2 = new PdfPCell(new Phrase("Quantity", headerFont));
    PdfPCell h3 = new PdfPCell(new Phrase("Unit Price", headerFont));
    PdfPCell h4 = new PdfPCell(new Phrase("totalprice", headerFont));

    h1.setHorizontalAlignment(Element.ALIGN_CENTER);
    h2.setHorizontalAlignment(Element.ALIGN_CENTER);
    h3.setHorizontalAlignment(Element.ALIGN_CENTER);
    h4.setHorizontalAlignment(Element.ALIGN_CENTER);

    table.addCell(h1);
    table.addCell(h2);
    table.addCell(h3);
    table.addCell(h4);

    // 🔹 Table Data
    for (InvoiceItems item : invoice.getIteams()) {
        table.addCell(new Phrase(item.getProductName(), normalFont));
        table.addCell(new Phrase(String.valueOf(item.getQuantity()), normalFont));
        table.addCell(new Phrase(String.valueOf(item.getUnitprice()), normalFont));
        table.addCell(new Phrase(String.valueOf(item.getTotalprice()), normalFont));
    }

    document.add(table);

    // 🔹 Total (Right aligned)
    Paragraph total = new Paragraph("Total: " + invoice.getTotal(), headerFont);
    total.setAlignment(Element.ALIGN_RIGHT);
    total.setSpacingBefore(10);
    document.add(total);

    document.close();

    return out.toByteArray();
}


    }

    

