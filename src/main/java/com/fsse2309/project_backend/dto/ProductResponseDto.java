package com.fsse2309.project_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.domainObject.ProductDetailsDataOut;
import com.fsse2309.project_backend.domainObject.TransactionProductDataOut;


import java.math.BigDecimal;

public class ProductResponseDto {
    @JsonProperty("id")
    private Integer productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("image_hover_url")
    private String imageHoverUrl;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("has_stock")
    private boolean hasStock;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("category")
    private String category;

    @JsonProperty("season")
    private Season season;

    public ProductResponseDto(ProductDetailsDataOut productDetailsDataOut) {
        this.productId = productDetailsDataOut.getPid();
        this.name = productDetailsDataOut.getName();
        this.imageUrl = productDetailsDataOut.getImageUrl();
        this.imageHoverUrl = productDetailsDataOut.getImageHoverUrl();
        this.price = productDetailsDataOut.getPrice();
        this.hasStock = productDetailsDataOut.getHasStock() > 0;
        this.brand = productDetailsDataOut.getBrand();
        this.category = productDetailsDataOut.getCategory();
        this.season = productDetailsDataOut.getSeason();
    }

    public ProductResponseDto(TransactionProductDataOut transactionProductDataOut) {
        this.productId = transactionProductDataOut.getPid();
        this.name = transactionProductDataOut.getName();
        this.imageUrl = transactionProductDataOut.getImageUrl();
        this.price = transactionProductDataOut.getPrice();
        this.hasStock = transactionProductDataOut.getHasStock() > 0;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public String getImageHoverUrl() {
        return imageHoverUrl;
    }

    public void setImageHoverUrl(String imageHoverUrl) {
        this.imageHoverUrl = imageHoverUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
