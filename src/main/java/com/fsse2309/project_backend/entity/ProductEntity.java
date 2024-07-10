package com.fsse2309.project_backend.entity;

import com.fsse2309.project_backend.domainObject.ProductDetailsData;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "image_hover_url")
    private String imageHoverUrl;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "has_stcok", nullable = false)
    private Integer hasStock;

    @Column(name = "description")
    private String description;

    public ProductEntity(){}

    public ProductEntity(ProductDetailsData productDetailsData) {
        this.pid = pid;
        this.name = productDetailsData.getName();
        this.imageUrl = productDetailsData.getImageUrl();
        this.imageHoverUrl = productDetailsData.getImageHoverUrl();
        this.price = productDetailsData.getPrice();
        this.hasStock = productDetailsData.getHasStock();
        this.description = productDetailsData.getDescription();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer productId) {
        this.pid = productId;
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
