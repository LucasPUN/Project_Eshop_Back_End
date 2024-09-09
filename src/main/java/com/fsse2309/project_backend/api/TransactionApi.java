package com.fsse2309.project_backend.api;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.domainObject.TransactionDataOut;
import com.fsse2309.project_backend.dto.TransactionResponseDto;
import com.fsse2309.project_backend.service.TransactionService;
import com.fsse2309.project_backend.utill.JwtUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PatchMapping("/{tid}/pay")
    public ResponseEntity<Map<String, String>> payTransaction(JwtAuthenticationToken jwt, @PathVariable Integer tid) {
        String stripeUrl = transactionService.processTransaction(JwtUtill.getFirebaseUser(jwt), tid);
        Map<String, String> response = new HashMap<>();
        response.put("url", stripeUrl); // Ensure the key is exactly 'url'
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{ssid}/finish")
    public TransactionResponseDto finishTransaction(JwtAuthenticationToken jwt,
                                                    @PathVariable String ssid){
        return new TransactionResponseDto(
                transactionService.finishTransaction(JwtUtill.getFirebaseUser(jwt),ssid)
        );
    }
}
