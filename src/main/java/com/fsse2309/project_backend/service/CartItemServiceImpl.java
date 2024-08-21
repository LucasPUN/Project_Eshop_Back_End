package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.CartItemDataOut;
import com.fsse2309.project_backend.domainObject.FirebaseUserData;
import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.ProductEntity;
import com.fsse2309.project_backend.entity.UserEntity;
import com.fsse2309.project_backend.exception.ProductDontExist;
import com.fsse2309.project_backend.repository.CartItemRepository;
import com.fsse2309.project_backend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{
    private UserService userService;
    private ProductRepository productRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductRepository productRepository, CartItemRepository cartItemRepository){
        this.userService = userService;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void addCartItem(int pid, int quantity, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productRepository.findByPid(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity,productEntity);

        CartItemEntity cartItemEntity;
        if (existingCartItem.isPresent()) {
            cartItemEntity = existingCartItem.get();
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
        } else {
            cartItemEntity = new CartItemEntity(userEntity, productEntity, quantity);
        }
        cartItemRepository.save(cartItemEntity);

    }

    @Override
    public List<CartItemDataOut> getCartItem(FirebaseUserData firebaseUserData){
        List<CartItemDataOut> cartItemDataOutList = new ArrayList<>();
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        for (CartItemEntity cartItemEntity : cartItemRepository.findAll()){
            if (cartItemEntity.getUser().equals(userEntity)){
                cartItemDataOutList.add(new CartItemDataOut(cartItemEntity));
            }
        }
        return cartItemDataOutList;
    }

    @Override
    public CartItemDataOut updateItem(int pid, int quantity, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productRepository.findByPid(pid);

        if (cartItemRepository.findByUserAndProduct(userEntity,productEntity).isPresent()){
            CartItemEntity existingCartItem = cartItemRepository.findByUserAndProduct(userEntity,productEntity).get();
            existingCartItem.setQuantity(quantity);
            cartItemRepository.save(existingCartItem);
            return new CartItemDataOut(existingCartItem);
        }
        throw new ProductDontExist();
    }

    @Transactional
    @Override
    public void deleteItem(int pid, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productRepository.findByPid(pid);
        Optional<CartItemEntity> cartItem = cartItemRepository.findByUserAndProduct(userEntity,productEntity);

        CartItemEntity cartItemEntity;
        if (cartItem.isPresent()){
           cartItemEntity = cartItem.get();
           cartItemRepository.delete(cartItemEntity);
        }
    }

    @Override
    public List<CartItemEntity> getEntityListByUser(UserEntity user){
        return cartItemRepository.findAllByUser(user);
    }

    @Transactional
    @Override
    public void emptyUserCart(UserEntity userEntity){
        cartItemRepository.deleteAllByUser(userEntity);
    }

}
