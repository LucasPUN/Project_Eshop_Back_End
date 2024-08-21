package com.fsse2309.project_backend.service;

import com.fsse2309.project_backend.config.EnvConfig;
import com.fsse2309.project_backend.entity.TransactionEntity;
import com.fsse2309.project_backend.entity.TransactionProductEntity;
import com.fsse2309.project_backend.exception.StripeSessionCreateException;
import com.fsse2309.project_backend.exception.StripeUnpaidException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StripeServiceImpl implements StripeService {
    Logger logger = LoggerFactory.getLogger(StripeServiceImpl.class);

    @Override
    public Session checkout(TransactionEntity transaction, List<TransactionProductEntity> transactionProductEntityList) {
        try {
            Stripe.apiKey = EnvConfig.stripeApiKey;

            List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

            for (TransactionProductEntity transactionProductEntity : transactionProductEntityList) {
                lineItems.add(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(transactionProductEntity.getQuantity().longValue())
                                .setPrice(transactionProductEntity.getStripePriceId())
                                .build()
                );
            }

            String YOUR_DOMAIN = "http://localhost:3000";
            SessionCreateParams params =
                    SessionCreateParams.builder()
                            .setMode(SessionCreateParams.Mode.PAYMENT)
                            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                            .setSuccessUrl(YOUR_DOMAIN + "/thankyou?session_id={CHECKOUT_SESSION_ID}")
                            .setCancelUrl(YOUR_DOMAIN + "/error")
                            .addAllLineItem(lineItems)
                            .build();
            return Session.create(params);
        } catch (StripeException e) {
            logger.error("Stripe exception", e);
            throw new StripeSessionCreateException();
        }
    }

    @Override
    public boolean isComplete(String sessionId) {
        try {
            Stripe.apiKey = EnvConfig.stripeApiKey;
            Session session = Session.retrieve(sessionId);
            logger.info("Session Status: " + session.getStatus());
            return session.getStatus().equals("complete");
        } catch (StripeException e) {
            throw new StripeUnpaidException("Session Uncompleted");
        }
    }
}