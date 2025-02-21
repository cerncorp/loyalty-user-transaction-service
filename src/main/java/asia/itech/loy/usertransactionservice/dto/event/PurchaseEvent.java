package asia.itech.loy.usertransactionservice.dto.event;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseEvent implements Serializable {
    private static final long serialVersionUID = -2436427958127782629L;

    private Long transactionId;  // An identifier for the transaction (optional, for correlation with other events)
    private Long userId;           // User making the purchase
    private Double amount;           // Purchase amount
    private Date purchaseDate;       // Date of the purchase
    private String productDetails;   // Information about the product(s) purchased
}
