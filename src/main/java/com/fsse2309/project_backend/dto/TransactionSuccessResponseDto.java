package com.fsse2309.project_backend.dto;

public class TransactionSuccessResponseDto {
    private String status;

    public TransactionSuccessResponseDto() {
        setStatus("success");
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }
}
