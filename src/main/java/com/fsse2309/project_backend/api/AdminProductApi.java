package com.fsse2309.project_backend.api;


import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.ProductDetailsData;
import com.fsse2309.project_backend.domainObject.ProductDetailsDataOut;
import com.fsse2309.project_backend.dto.ProductIdResponseDto;
import com.fsse2309.project_backend.dto.ProductResponseDto;
import com.fsse2309.project_backend.dto.ProductResquestDto;
import com.fsse2309.project_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin({EnvConfig.devEnvBaseUrl,EnvConfig.prodBaseUrl,EnvConfig.devEnvBaseUrl1})
public class AdminProductApi {
    private ProductService productService;

    @Autowired
    public AdminProductApi(ProductService productService){
        this.productService = productService;
    }

    @PostMapping()
    public ProductResponseDto productResponseDto(@RequestBody ProductResquestDto productResquestDto){
        ProductDetailsData productDetailsData = new ProductDetailsData(productResquestDto);
        ProductDetailsDataOut productDetailsDataOut = productService.createProduct(productDetailsData);

        ProductResponseDto productResponseDto = new ProductResponseDto(productDetailsDataOut);
        return productResponseDto;
    }

    @PutMapping("/{id}")
    public ProductIdResponseDto updateProduct(@PathVariable int id, @RequestBody ProductResquestDto productRequestDto) {
        ProductDetailsData productDetailsData = new ProductDetailsData(productRequestDto);
        ProductDetailsDataOut productDetailsDataOut = productService.updateProduct(id,productDetailsData);
        return new ProductIdResponseDto(productDetailsDataOut);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
