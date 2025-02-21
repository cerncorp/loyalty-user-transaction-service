package asia.itech.loy.usertransactionservice.job.kafka;

import asia.itech.loy.usertransactionservice.service.IPurchaseEventProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurchaseEventSchedulerJob {

    @Autowired
    IPurchaseEventProducerService purchaseEventProducerService;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
}
