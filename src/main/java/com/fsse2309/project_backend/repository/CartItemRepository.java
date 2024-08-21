package com.fsse2309.project_backend.repository;

import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.ProductEntity;
import com.fsse2309.project_backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
    Optional<CartItemEntity> findByUserAndProduct (UserEntity userEntity, ProductEntity productEntity);
    List<CartItemEntity> findAllByUser (UserEntity userEntity);
    CartItemEntity findByUser(UserEntity userEntity);
    int deleteAllByUser(UserEntity userEntity);

}
