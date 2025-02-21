package asia.itech.loy.usertransactionservice.service.impl;

import asia.itech.loy.usertransactionservice.dto.event.PurchaseEvent;
import asia.itech.loy.usertransactionservice.service.IPurchaseEventProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PurchaseEventProducerService implements IPurchaseEventProducerService {


    private final KafkaTemplate<String, PurchaseEvent> kafkaTemplate;

    @Value(value = "${kafka.topic.purchase-event.name}")
    private String purchaseEventTopicName;

    public PurchaseEventProducerService(KafkaTemplate<String, PurchaseEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPurchaseEvent(PurchaseEvent purchaseEvent) {
        try {
            log.info("Sending purchase event to topic {} with event {}", purchaseEventTopicName, purchaseEvent);

            kafkaTemplate.send(purchaseEventTopicName, purchaseEvent);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // todo: error handler
        }
    }
}
