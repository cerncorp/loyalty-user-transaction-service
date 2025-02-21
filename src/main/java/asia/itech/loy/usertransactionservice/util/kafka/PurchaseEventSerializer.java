package asia.itech.loy.usertransactionservice.util.kafka;

import asia.itech.loy.usertransactionservice.dto.event.PurchaseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class PurchaseEventSerializer implements Serializer<PurchaseEvent> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param s
     * @param purchaseEvent
     * @return
     */
    @Override
    public byte[] serialize(String s, PurchaseEvent purchaseEvent) {
        try {
            if (purchaseEvent == null){
                log.info("Null received at serializing");
                return null;
            }
            return objectMapper.writeValueAsBytes(purchaseEvent);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing PurchaseEvent to byte[]");
        }
    }
}
