package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.domainObject.FirebaseUserData;
import com.fsse2309.project_backend.domainObject.TransactionDataOut;

import java.util.List;

public interface TransactionService {


    TransactionDataOut prepareTransaction(FirebaseUserData firebaseUserData);

    TransactionDataOut getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid);

    String processTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionDataOut finishTransaction(FirebaseUserData firebaseUserData, String ssid);

    List<TransactionDataOut> getAllTransaction();

    List<TransactionDataOut> getAllTransactionByUser(FirebaseUserData firebaseUserData);
}
