package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import com.stripe.model.checkout.Session;

import java.util.List;

public interface StripeService {
    Session checkout(TransactionEntity transaction, List<TransactionProductEntity> transactionProductEntityList);


    boolean isComplete(String sessionId);
}
