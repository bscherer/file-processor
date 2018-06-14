package com.mycompany.fileprocessor.domain.entity;

import java.math.BigDecimal;

public class SaleItem extends Entity {
    
    private Long id;
    private Long quantity;
    private BigDecimal price;

    public SaleItem(Long id, Long quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
