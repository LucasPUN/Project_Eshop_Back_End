package com.fsse2309.project_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.domainObject.ProductDetailsDataOut;

import java.math.BigDecimal;

public class ProductIdResponseDto {
    @JsonProperty("id")
    private Integer pid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("stock")
    private Integer hasStock;

    public ProductIdResponseDto(ProductDetailsDataOut productDetailsDataOut) {
        this.pid = productDetailsDataOut.getPid();
        this.name = productDetailsDataOut.getName();
        this.description = productDetailsDataOut.getDescription();
        this.imageUrl = productDetailsDataOut.getImageUrl();
        this.price = productDetailsDataOut.getPrice();
        this.hasStock = productDetailsDataOut.getHasStock();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
