package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.ProductDetailsData;
import com.fsse2309.project_backend.domainObject.ProductDetailsDataOut;
import com.fsse2309.project_backend.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductDetailsDataOut createProduct(ProductDetailsData productDetailsData);

    ProductDetailsDataOut updateProduct(int id, ProductDetailsData productDetailsData);

    List<ProductDetailsDataOut> getAllProduct();

    ProductDetailsDataOut getById(Integer id);

    List<ProductDetailsDataOut> getByName(String name);

    boolean deductStock(Integer pid, Integer quantity);

    void deleteProduct(int id);


}
