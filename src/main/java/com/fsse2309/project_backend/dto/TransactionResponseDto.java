package com.fsse2309.project_backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2309.project_backend.domainObject.TransactionDataOut;
import com.fsse2309.project_backend.domainObject.TransactionProductDataOut;
import com.fsse2309.project_backend.status.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {

    private Integer id;
    @JsonProperty("buyer_uid")
    private Integer buyerUid;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime datetime;
    private TransactionStatus status;
    private BigDecimal total;
    @JsonProperty("Item")
    private List<TransactionProductResponseDto> transactionProductResponseDtoList = new ArrayList<>();

    public TransactionResponseDto(TransactionDataOut transactionDataOut) {
        this.id = transactionDataOut.getTid();
        this.buyerUid = transactionDataOut.getBuyer_uid().getUid();
        this.datetime = transactionDataOut.getDatetime();
        this.status = transactionDataOut.getStatus();
        this.total = transactionDataOut.getTotal();
        for (TransactionProductDataOut transactionProductDataOut : transactionDataOut.getTransactionProductDataOutList()){
            this.transactionProductResponseDtoList.add(new TransactionProductResponseDto(transactionProductDataOut));
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Integer buyerUid) {
        this.buyerUid = buyerUid;
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

    public List<TransactionProductResponseDto> getTransactionProductResponseDtoList() {
        return transactionProductResponseDtoList;
    }

    public void setTransactionProductResponseDtoList(List<TransactionProductResponseDto> transactionProductResponseDtoList) {
        this.transactionProductResponseDtoList = transactionProductResponseDtoList;
    }
}
