package com.invoice.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.application.entity.Invoice;

public interface InvoiceRepository extends JpaRepository <Invoice, Integer>{

}

