package com.invoice.application.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.application.dto.InvoiceDTO;
import com.invoice.application.dto.InvoivceitemDTO;
import com.invoice.application.entity.Invoice;
import com.invoice.application.entity.InvoiceItems;
import com.invoice.application.repository.InvoiceRepository;
import com.invoice.application.repository.Invoiceitemrepository;


@Service
public class InvoiceService {

    @Autowired
    Pdfservice pdf;
    @Autowired
    InvoiceRepository Invoicerepo;
    @Autowired
    Invoiceitemrepository Invoiceitemrepo;

    public InvoiceDTO Createinvoice(InvoiceDTO invoiceDTO){
           Invoice invoice = new Invoice();
           invoice.setCompanyName(invoiceDTO.getCompanyname());
           invoice.setCreatedAT(LocalDateTime.now());
           List<InvoiceItems> items = new ArrayList<>();
           double total = 0;

           for(InvoivceitemDTO  invoiceitem : invoiceDTO.getItem()){
               InvoiceItems item = new InvoiceItems();
               item .setProductName(invoiceitem.getProductname());
               item.setQuantity(invoiceitem.getQuantity());
               item.setUnitprice(invoiceitem.getUnitprice());
                   
                 double amount = invoiceitem.getQuantity()*invoiceitem.getUnitprice();
                 item.setTotalprice(amount);
                 item.setInvoice(invoice);
                 total += amount;
                 items.add(item);

                }    
                 invoice.setIteams(items);
                 invoice.setTotal(total);
                  Invoice saved = Invoicerepo.save(invoice);
                
               List<InvoivceitemDTO> itemDTOs = new ArrayList<>();

               for (InvoiceItems iteams: saved.getIteams()) {
                InvoivceitemDTO dtoItem = new InvoivceitemDTO();
                dtoItem.setProductname(iteams.getProductName());
                dtoItem.setQuantity(iteams.getQuantity());
                dtoItem.setUnitprice(iteams.getUnitprice());
                itemDTOs.add(dtoItem);
                
            }
                 return  new InvoiceDTO(saved.getCompanyName(),itemDTOs);       
                    
            }

            public byte[] downloadInvoicePdf(int id) throws Exception {

            Invoice invoice = Invoicerepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Invoice not found"));

            return pdf.generatepdf(invoice);
            }

           
         }
    


