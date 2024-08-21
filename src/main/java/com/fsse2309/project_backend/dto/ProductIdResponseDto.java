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

    @JsonProperty("image_hover_url")
    private String imageHoverUrl;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("stock")
    private Integer hasStock;
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("category")
    private String category;

    @JsonProperty("season")
    private Season season;

    public ProductIdResponseDto(ProductDetailsDataOut productDetailsDataOut) {
        this.pid = productDetailsDataOut.getPid();
        this.name = productDetailsDataOut.getName();
        this.description = productDetailsDataOut.getDescription();
        this.imageUrl = productDetailsDataOut.getImageUrl();
        this.imageHoverUrl = productDetailsDataOut.getImageHoverUrl();
        this.price = productDetailsDataOut.getPrice();
        this.hasStock = productDetailsDataOut.getHasStock();
        this.brand = productDetailsDataOut.getBrand();
        this.category = productDetailsDataOut.getCategory();
        this.season = productDetailsDataOut.getSeason();
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

    public String getImageHoverUrl() {
        return imageHoverUrl;
    }

    public void setImageHoverUrl(String imageHoverUrl) {
        this.imageHoverUrl = imageHoverUrl;
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
