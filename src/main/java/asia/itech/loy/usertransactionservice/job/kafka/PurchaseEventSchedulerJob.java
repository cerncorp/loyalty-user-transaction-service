package asia.itech.loy.usertransactionservice.job.kafka;

import asia.itech.loy.usertransactionservice.dto.event.PurchaseEvent;
import asia.itech.loy.usertransactionservice.service.IPurchaseEventProducerService;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PurchaseEventSchedulerJob {

    @Autowired
    IPurchaseEventProducerService purchaseEventProducerService;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {

        Faker faker = new Faker();

        PurchaseEvent purchaseEvent = new PurchaseEvent(
                faker.number().randomNumber(5, false),
                faker.number().randomNumber(5, false),
                faker.number().randomDouble(9, 100000, 100000000),
                faker.date().past(30, TimeUnit.DAYS),
                faker.university().name()

        );
        log.info("Sending purchase event: {}", purchaseEvent);

        // todo: validation purchase event before sending

        purchaseEventProducerService.sendPurchaseEvent(purchaseEvent);

    }
}
