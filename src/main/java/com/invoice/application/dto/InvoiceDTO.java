package com.invoice.application.dto;

import java.util.List;

public class InvoiceDTO {
    private String companyname ;
    private List<InvoivceitemDTO>  item;
    
    public InvoiceDTO(){}

    public InvoiceDTO(String companyname , List<InvoivceitemDTO>  item ){
        this.companyname = companyname;
        this.item = item;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public List<InvoivceitemDTO> getItem() {
        return item;
    }

    public void setItem(List<InvoivceitemDTO> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "InvoiceDTO [companyname=" + companyname + ", item=" + item + "]";
    }

}

