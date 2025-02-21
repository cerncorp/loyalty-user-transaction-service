package asia.itech.loy.usertransactionservice.controller;

import asia.itech.loy.usertransactionservice.dto.event.PurchaseEvent;
import asia.itech.loy.usertransactionservice.dto.request.UserPurchaseRequest;
import asia.itech.loy.usertransactionservice.service.IPurchaseEventProducerService;
import com.github.javafaker.Faker;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class LoyaltyPointsController {

    @Autowired
    IPurchaseEventProducerService purchaseEventProducerService;

    @PostMapping("/loyalty/user-purchase")
    public ResponseEntity<String> postLoyaltyPoints(
            @Valid @RequestBody UserPurchaseRequest request
    ) {

        log.info("Loyalty Points request: {}", request);
        Faker faker = new Faker();

        PurchaseEvent purchaseEvent = new PurchaseEvent(
                faker.number().randomNumber(5, false),
                request.userId(), // faker.number().randomNumber(5, false),
                request.amount(), // faker.number().randomDouble(9, 100000, 100000000),
                faker.date().past(30, TimeUnit.DAYS),
                faker.university().name()

        );
        log.info("Sending purchase event: {}", purchaseEvent);

        // todo: validation purchase event before sending

        purchaseEventProducerService.sendPurchaseEvent(purchaseEvent);


        return ResponseEntity.noContent().build();
    }
}
