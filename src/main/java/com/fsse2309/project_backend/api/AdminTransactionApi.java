package com.fsse2309.project_backend.api;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.TransactionDataOut;
import com.fsse2309.project_backend.dto.TransactionResponseDto;
import com.fsse2309.project_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin({EnvConfig.devEnvBaseUrl,EnvConfig.prodBaseUrl,EnvConfig.devEnvBaseUrl1})
public class AdminTransactionApi {
    private TransactionService transactionService;

    @Autowired
    public AdminTransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping()
    public List<TransactionResponseDto> getAllTransaction(){
        List<TransactionDataOut> transactionDataOutList = transactionService.getAllTransaction();
        List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<>();
        for (TransactionDataOut transactionDataOut: transactionDataOutList){
            transactionResponseDtoList.add(new TransactionResponseDto(transactionDataOut));
        }
        return transactionResponseDtoList;
    }
}
