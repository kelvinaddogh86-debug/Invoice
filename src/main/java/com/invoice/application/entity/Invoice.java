package com.invoice.application.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String companyName;
    private LocalDateTime createdAT;
    private Double total;
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<InvoiceItems> iteams = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<InvoiceItems> getIteams() {
        return iteams;
    }

    public void setIteams(List<InvoiceItems> iteams) {
        this.iteams = iteams;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", companyName=" + companyName + ", createdAT=" + createdAT + ", total=" + total
                + ", iteams=" + iteams + "]";
    }

   

    
    
}
