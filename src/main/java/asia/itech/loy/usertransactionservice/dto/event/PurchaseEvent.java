package asia.itech.loy.usertransactionservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@AllArgsConstructor
public class PurchaseEvent implements Serializable {
    private static final long serialVersionUID = 388334963818864418L;

    private String transactionId;  // An identifier for the transaction (optional, for correlation with other events)
    private String userId;           // User making the purchase
    private double amount;           // Purchase amount
    private Date purchaseDate;       // Date of the purchase
    private String productDetails;   // Information about the product(s) purchased
}
