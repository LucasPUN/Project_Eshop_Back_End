package com.fsse2309.project_backend.repository;

import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.ProductEntity;
import com.fsse2309.project_backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findByName(String name);

    ProductEntity findByPid(Integer pid);

}
