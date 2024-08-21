package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.CartItemDataOut;
import com.fsse2309.project_backend.domainObject.FirebaseUserData;
import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.util.concurrent.CompletableToListenableFutureAdapter;

import java.util.List;

public interface CartItemService {
    void addCartItem(int pid, int quantity, FirebaseUserData firebaseUserData);

    List<CartItemDataOut> getCartItem(FirebaseUserData firebaseUserData);

    CartItemDataOut updateItem(int pid, int quantity, FirebaseUserData firebaseUserData);

    void deleteItem(int pid, FirebaseUserData firebaseUserData);


    List<CartItemEntity> getEntityListByUser(UserEntity user);

    @Transactional
    void emptyUserCart(UserEntity userEntity);


}
