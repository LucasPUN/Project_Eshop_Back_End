package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import com.fsse2309.project_backend.repository.TransactionProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionProductServiceimpl implements TransactionProductService{
    private CartItemService cartItemService;

    private TransactionProductRepository transactionProductRepository;

    public TransactionProductServiceimpl(CartItemService cartItemService, TransactionProductRepository transactionProductRepository) {
        this.cartItemService = cartItemService;
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public List<TransactionProductEntity> createEntityList(TransactionEntity transactionEntity){
        List<CartItemEntity> cartItemEntityList = cartItemService.getEntityListByUser(transactionEntity.getUserEntity());
        List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemEntityList){
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transactionEntity,cartItemEntity);
            transactionProductEntity = transactionProductRepository.save(transactionProductEntity);
            transactionProductEntityList.add(transactionProductEntity);
        }
        return transactionProductEntityList;
    }
}
