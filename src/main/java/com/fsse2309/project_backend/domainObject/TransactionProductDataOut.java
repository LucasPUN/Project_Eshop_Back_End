package com.fsse2309.project_backend.domainObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class TransactionProductDataOut {
    private Integer tpid;
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer hasStock;
    private String description;
    private Integer quantity;

    public TransactionProductDataOut(TransactionProductEntity transactionProductEntity) {
        this.tpid = transactionProductEntity.getTpid();
        this.pid = transactionProductEntity.getPid();
        this.name = transactionProductEntity.getName();
        this.imageUrl = transactionProductEntity.getImageUrl();
        this.price = transactionProductEntity.getPrice();
        this.hasStock = transactionProductEntity.getHasStock();
        this.description = transactionProductEntity.getDescription();
        this.quantity = transactionProductEntity.getQuantity();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getHasStock() {
        return hasStock;
    }

    public void setHasStock(Integer hasStock) {
        this.hasStock = hasStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
