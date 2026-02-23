package com.invoice.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.application.entity.InvoiceItems;

public interface Invoiceitemrepository  extends JpaRepository< InvoiceItems, Integer> {

}
