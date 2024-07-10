package com.fsse2309.project_backend.domainObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.dto.ProductResquestDto;

import java.math.BigDecimal;

public class ProductDetailsData {

    private String name;
    private String imageUrl;
    private String imageHoverUrl;
    private BigDecimal price;
    private Integer hasStock;
    private String description;

    public ProductDetailsData(ProductResquestDto productResquestDto) {
        this.name = productResquestDto.getName();
        this.imageUrl = productResquestDto.getImageUrl();
        this.imageHoverUrl = productResquestDto.getImageHoverUrl();
        this.price = productResquestDto.getPrice();
        this.hasStock = productResquestDto.getHasStock();
        this.description = productResquestDto.getDescription();
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
}
