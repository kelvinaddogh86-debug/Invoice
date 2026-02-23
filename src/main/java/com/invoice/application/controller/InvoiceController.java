package com.invoice.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.application.dto.InvoiceDTO;
import com.invoice.application.service.InvoiceService;
import com.invoice.application.service.Pdfservice;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceService service;
     @Autowired
    Pdfservice pdfservice;


    @GetMapping("/test")
   public String test() {
    return "API is working!";
   }

    @PostMapping("/invoice/create")
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO dto){
    InvoiceDTO savedInvoice = service.Createinvoice(dto); // saves entity
      return ResponseEntity.ok(savedInvoice);
   }

    @GetMapping("/invoice/{id}/pdf")
    public ResponseEntity<byte[]> download(@PathVariable int id)throws Exception {
        
      byte[] pdf = service.downloadInvoicePdf(id);
      return ResponseEntity.ok()
                           .header("Content-Disposition", "attachment; filename=invoice.pdf")
                           .contentType(MediaType.APPLICATION_PDF)
                           .body(pdf);
    }
    
}
