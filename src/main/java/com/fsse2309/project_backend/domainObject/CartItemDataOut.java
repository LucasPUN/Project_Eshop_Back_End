package com.fsse2309.project_backend.domainObject;

import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.ProductEntity;
import com.fsse2309.project_backend.entity.UserEntity;

public class CartItemDataOut {
    private Integer cart_id;

    private UserEntity user;

    private ProductEntity product;

    private Integer quantity;

    public CartItemDataOut(CartItemEntity cartItemEntity) {
        this.cart_id = cartItemEntity.getCid();
        this.user = cartItemEntity.getUser();
        this.product = cartItemEntity.getProduct();
        this.quantity = cartItemEntity.getQuantity();
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
