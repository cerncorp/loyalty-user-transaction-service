package asia.itech.loy.usertransactionservice.config;


import asia.itech.loy.usertransactionservice.dto.event.PurchaseEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${kafka.topic.purchase-event.app-id}")
    private String appId;

    // guide: producer Factory and Configuration with value type: PurchaseEventSerializer of PurchaseEvent
    @Bean
    public ProducerFactory<String, PurchaseEvent> producerPurchaseEventFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, appId);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "asia.itech.loy.usertransactionservice.util.kafka.PurchaseEventSerializer");

        return new DefaultKafkaProducerFactory<>(configProps);
    }


    @Bean
    public KafkaTemplate<String, PurchaseEvent> kafkaPurchaseEventTemplate() {
        return new KafkaTemplate<>(producerPurchaseEventFactory());
    }
}

