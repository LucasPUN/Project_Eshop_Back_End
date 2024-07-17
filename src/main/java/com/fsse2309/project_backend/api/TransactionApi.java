package com.fsse2309.project_backend.api;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.TransactionDataOut;
import com.fsse2309.project_backend.dto.TransactionResponseDto;
import com.fsse2309.project_backend.dto.TransactionSuccessResponseDto;
import com.fsse2309.project_backend.service.TransactionService;
import com.fsse2309.project_backend.utill.JwtUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin({EnvConfig.devEnvBaseUrl,EnvConfig.prodBaseUrl,EnvConfig.devEnvBaseUrl1})
public class TransactionApi {

    private TransactionService transactionService;

    @Autowired
    public TransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto createTransaction(JwtAuthenticationToken jwt){
        TransactionDataOut transactionDataOut = transactionService.prepareTransaction(JwtUtill.getFirebaseUser(jwt));
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transactionDataOut);
        return transactionResponseDto;
    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransaction(JwtAuthenticationToken jwt,
                                                 @PathVariable Integer tid){
        TransactionDataOut transactionDataOut = transactionService.getTransactionByTid(JwtUtill.getFirebaseUser(jwt),tid);
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto(transactionDataOut);
        return transactionResponseDto;
    }

    @PatchMapping("{tid}/pay")
    public TransactionSuccessResponseDto payTransaction(JwtAuthenticationToken jwt,
                                                        @PathVariable Integer tid){
        transactionService.processTransacton(JwtUtill.getFirebaseUser(jwt),tid);
        return new TransactionSuccessResponseDto();
    }

    @PatchMapping("{tid}/finish")
    public TransactionResponseDto finishTransaction(JwtAuthenticationToken jwt,
                                                    @PathVariable Integer tid){
        return new TransactionResponseDto(
                transactionService.finishTransaction(JwtUtill.getFirebaseUser(jwt),tid)
        );
    }
}
