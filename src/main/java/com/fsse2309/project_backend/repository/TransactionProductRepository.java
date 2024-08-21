package com.fsse2309.project_backend.repository;

import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionProductRepository extends CrudRepository <TransactionProductEntity, Integer>{

    List<TransactionProductEntity> findByTransactionEntity(TransactionEntity transactionEntity);
}
