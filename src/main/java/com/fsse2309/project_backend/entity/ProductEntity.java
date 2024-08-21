package com.fsse2309.project_backend.entity;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.ProductDetailsData;
import com.fsse2309.project_backend.dto.Season;
import com.stripe.Stripe;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Column(name = "has_stock", nullable = false)
    private Integer hasStock;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "season", nullable = false)
    @Enumerated(EnumType.STRING)
    private Season season;

    @Column(name = "stripe_product_id")
    private String stripeProductId;

    @Column(name = "stripe_price_id")
    private String stripePriceId;

    public String getStripeProductId() {
        return stripeProductId;
    }

    public void setStripeProductId(String stripeProductId) {
        this.stripeProductId = stripeProductId;
    }

    public String getStripePriceId() {
        return stripePriceId;
    }

    public void setStripePriceId(String stripePriceId) {
        this.stripePriceId = stripePriceId;
    }

    @PrePersist
    public void uploadToStripe() throws Exception {
        Stripe.apiKey = EnvConfig.stripeApiKey;

        // 创建Stripe产品
        Product stripeProduct = Product.create(
                ProductCreateParams.builder()
                        .setName(this.name)
                        .setDescription(this.description)
                        .addImage(this.imageUrl)
                        .build()
        );

        // 创建Stripe价格
        Price stripePrice = Price.create(
                PriceCreateParams.builder()
                        .setCurrency("hkd")
                        .setProduct(stripeProduct.getId())
                        .setUnitAmount((this.price.multiply(BigDecimal.valueOf(100)).longValue())) // 转换为分
                        .build()
        );

        // 假设你有个字段存储Stripe的产品ID和价格ID
        this.stripeProductId = stripeProduct.getId();
        this.stripePriceId = stripePrice.getId();
    }

    public ProductEntity() {}

    public ProductEntity(ProductDetailsData productDetailsData) {
        this.name = productDetailsData.getName();
        this.imageUrl = productDetailsData.getImageUrl();
        this.imageHoverUrl = productDetailsData.getImageHoverUrl();
        this.price = productDetailsData.getPrice();
        this.hasStock = productDetailsData.getHasStock();
        this.description = productDetailsData.getDescription();
        this.brand = productDetailsData.getBrand();
        this.category = productDetailsData.getCategory();
        this.season = productDetailsData.getSeason();
    }

    public void setProductEntity(ProductDetailsData productDetailsData) {
        this.name = productDetailsData.getName();
        this.imageUrl = productDetailsData.getImageUrl();
        this.imageHoverUrl = productDetailsData.getImageHoverUrl();
        this.price = productDetailsData.getPrice();
        this.hasStock = productDetailsData.getHasStock();
        this.description = productDetailsData.getDescription();
        this.brand = productDetailsData.getBrand();
        this.category = productDetailsData.getCategory();
        this.season = productDetailsData.getSeason();
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
