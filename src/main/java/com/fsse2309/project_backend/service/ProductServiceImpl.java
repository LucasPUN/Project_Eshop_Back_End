package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.ProductDetailsData;
import com.fsse2309.project_backend.domainObject.ProductDetailsDataOut;
import com.fsse2309.project_backend.entity.ProductEntity;
import com.fsse2309.project_backend.exception.ProductDontExist;
import com.fsse2309.project_backend.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDetailsDataOut createProduct(ProductDetailsData productDetailsData) {
        ProductEntity productEntity = new ProductEntity(productDetailsData);
        ProductDetailsDataOut productDetailsDataOut = new ProductDetailsDataOut(productRepository.save(productEntity));
        return productDetailsDataOut;
    }

    @Override
    public ProductDetailsDataOut updateProduct(int id, ProductDetailsData productDetailsData) {
        ProductEntity existingProductEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existingProductEntity.setProductEntity(productDetailsData);
        ProductDetailsDataOut productDetailsDataOut = new ProductDetailsDataOut(productRepository.save(existingProductEntity));
        return productDetailsDataOut;
    }

    @Override
    public List<ProductDetailsDataOut> getAllProduct() {
        List<ProductDetailsDataOut> productDetailsDataOutList = new ArrayList<>();

        for (ProductEntity productEntity : productRepository.findAll()) {
            ProductDetailsDataOut productDetailsDataOut = new ProductDetailsDataOut(productEntity);
            productDetailsDataOutList.add(productDetailsDataOut);
        }
        return productDetailsDataOutList;
    }

    @Override
    public ProductDetailsDataOut getById(Integer id) {
        if (productRepository.findById(id).isEmpty()) {
            logger.warn("Product do not Exist");
            throw new ProductDontExist();
        }
        return new ProductDetailsDataOut(productRepository.findById(id).get());
    }

    @Override
    public List<ProductDetailsDataOut> getByName(String name) {
        List<ProductDetailsDataOut> productDetailsDataOutList = new ArrayList<>();
        for (ProductEntity productEntity : productRepository.findByName(name)) {
            productDetailsDataOutList.add(new ProductDetailsDataOut(productEntity));
        }
        return productDetailsDataOutList;
    }

    @Override
    public void deleteProduct(int id) {
        ProductEntity existingProductEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(existingProductEntity);
    }

    @Override
    public boolean deductStock(Integer pid, Integer quantity) {
        ProductEntity productEntity = productRepository.findByPid(pid);

        if (productEntity.getHasStock() - quantity < 0) {
            throw new ProductDontExist();
        }

        productEntity.setHasStock(productEntity.getHasStock() - quantity);
        productRepository.save(productEntity);
        return true;
    }
}
