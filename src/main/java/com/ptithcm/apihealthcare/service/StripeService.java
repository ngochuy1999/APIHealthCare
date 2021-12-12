package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    public ResponseEntity<ObjectResponse> charge(ChargeRequest chargeRequest)
            throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        try {
            Charge charge = Charge.create(chargeParams);
            return ResponseEntity.ok(new ObjectResponse("1", "Thanh toán tin thành công", true, charge.getId()));
        }catch (StripeException stripeException){
            return ResponseEntity.ok(new ObjectResponse("0", stripeException.getMessage(), false, null));
        }
    }

    public String createCheckOutSession() throws StripeException {
        String DOMAIN = "http://localhost:3000/checkout";
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.EPS)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.SOFORT)
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(DOMAIN + "?success=true")
                        .setCancelUrl(DOMAIN + "?canceled=true")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setPriceData(
                                                SessionCreateParams.LineItem.PriceData.builder()
                                                        .setCurrency("EUR")
                                                        .setUnitAmount(Long.valueOf(5000))
                                                        .setProductData(
                                                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                        .setName("Laptop X")
                                                                        .setDescription("Laptop X for sale")
                                                                        .build()
                                                        )
                                                        .build()
                                        )
                                        .setQuantity(1L)
                                        // TODO: replace this with the `price` of the product you want to sell
                                        .build())
                        .build();
        Session session = Session.create(params);
        return session.getUrl();
    }
}