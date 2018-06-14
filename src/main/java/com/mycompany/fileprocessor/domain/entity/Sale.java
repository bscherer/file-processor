package com.mycompany.fileprocessor.domain.entity;

import java.util.List;

public class Sale extends Entity {
    
    private Long id;
    private List<SaleItem> items;
    private String salesmanName;

    public Sale(Long id, List<SaleItem> items, String salesmanName) {
        this.id = id;
        this.items = items;
        this.salesmanName = salesmanName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
    
    public void addItens(SaleItem item) {
        this.items.add(item);
    }
}
