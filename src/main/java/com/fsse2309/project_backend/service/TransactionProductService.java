package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionProductService {
    List<TransactionProductEntity> createEntityList(TransactionEntity transactionEntity);
}
