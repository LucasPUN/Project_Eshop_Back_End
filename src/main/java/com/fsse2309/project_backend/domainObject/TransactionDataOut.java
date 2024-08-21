package com.fsse2309.project_backend.domainObject;

import com.fsse2309.project_backend.entity.CartItemEntity;
import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import com.fsse2309.project_backend.entity.UserEntity;
import com.fsse2309.project_backend.status.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDataOut {
    private Integer tid;
    private UserEntity buyer_uid; //need fix
    private LocalDateTime datetime;
    private TransactionStatus status;
    private BigDecimal total;
    private List<TransactionProductDataOut> transactionProductDataOutList = new ArrayList<>();;

    public TransactionDataOut(TransactionEntity transactionEntity) {
        this.tid = transactionEntity.getTid();
        this.buyer_uid = transactionEntity.getUserEntity();
        this.datetime = transactionEntity.getDatetime();
        this.status = transactionEntity.getStatus();
        this.total = transactionEntity.getTotal();
        setTransactionProductList(transactionEntity);
    }


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getBuyer_uid() {
        return buyer_uid;
    }

    public void setBuyer_uid(UserEntity buyer_uid) {
        this.buyer_uid = buyer_uid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProductDataOut> getTransactionProductDataOutList() {
        return transactionProductDataOutList;
    }

    public void setTransactionProductDataOutList(List<TransactionProductDataOut> transactionProductDataOutList) {
        this.transactionProductDataOutList = transactionProductDataOutList;
    }

    public void setTransactionProductList(TransactionEntity transactionEntity){
        for (TransactionProductEntity transactionProductEntity : transactionEntity.getTransactionProductEntityList()){
            this.transactionProductDataOutList.add(new TransactionProductDataOut(transactionProductEntity));
        }
    }
}
