package com.fsse2309.project_backend.api;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.ProductDetailsData;
import com.fsse2309.project_backend.domainObject.ProductDetailsDataOut;
import com.fsse2309.project_backend.dto.ProductIdResponseDto;
import com.fsse2309.project_backend.dto.ProductResponseDto;
import com.fsse2309.project_backend.dto.ProductResquestDto;
import com.fsse2309.project_backend.entity.ProductEntity;
import com.fsse2309.project_backend.exception.ProductDontExist;
import com.fsse2309.project_backend.repository.ProductRepository;
import com.fsse2309.project_backend.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin({EnvConfig.devEnvBaseUrl,EnvConfig.prodBaseUrl,EnvConfig.devEnvBaseUrl1})
public class ProductApi {
    private ProductService productService;

    @Autowired
    public ProductApi(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponseDto> getAllProductDto(){
        List<ProductDetailsDataOut> productDetailsDataOutList = productService.getAllProduct();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for (ProductDetailsDataOut productDetailsDataOut : productDetailsDataOutList){
            productResponseDtoList.add(new ProductResponseDto(productDetailsDataOut));
        }
        return productResponseDtoList;
    }

    @GetMapping("/{id}")
    public ProductIdResponseDto getProductByID(@PathVariable Integer id){
        ProductDetailsDataOut productDetailsDataOut = productService.getById(id);
        ProductIdResponseDto productIdResponseDto = new ProductIdResponseDto(productDetailsDataOut);
        return productIdResponseDto;
    }

    @GetMapping("/name/{name}")
    public List<ProductIdResponseDto> getProductByName(@PathVariable String name){
        List<ProductDetailsDataOut> productDetailsDataOutList = productService.getByName(name);
        List<ProductIdResponseDto> productIdResponseDtoList = new ArrayList<>();
        for (ProductDetailsDataOut productDetailsDataOut: productDetailsDataOutList){
            ProductIdResponseDto productIdResponseDto = new ProductIdResponseDto(productDetailsDataOut);
            productIdResponseDtoList.add(productIdResponseDto);
        }
        return productIdResponseDtoList;
    }

}
