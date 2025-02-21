package asia.itech.loy.usertransactionservice.service;

import asia.itech.loy.usertransactionservice.dto.event.PurchaseEvent;

public interface IPurchaseEventProducerService {
    void sendPurchaseEvent(PurchaseEvent purchaseEvent);
}
