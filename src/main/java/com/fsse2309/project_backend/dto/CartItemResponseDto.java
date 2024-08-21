package com.fsse2309.project_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.domainObject.CartItemDataOut;
import com.fsse2309.project_backend.entity.ProductEntity;

import java.math.BigDecimal;

public class CartItemResponseDto {

    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("cart_quantity")
    private Integer quantity;
    @JsonProperty("stock")
    private Integer hasStock;


    public CartItemResponseDto(CartItemDataOut cartItemDataOut) {
        this.pid = cartItemDataOut.getProduct().getPid();
        this.name = cartItemDataOut.getProduct().getName();
        this.imageUrl = cartItemDataOut.getProduct().getImageUrl();
        this.price = cartItemDataOut.getProduct().getPrice();
        this.quantity = cartItemDataOut.getQuantity();
        this.hasStock = cartItemDataOut.getProduct().getHasStock();
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}



