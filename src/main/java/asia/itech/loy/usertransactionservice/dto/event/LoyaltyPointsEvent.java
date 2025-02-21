package asia.itech.loy.usertransactionservice.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class LoyaltyPointsEvent implements Serializable {
    private static final long serialVersionUID = 1598099695119678058L;

    private String userId;         // The ID of the user whose loyalty points are updated
    private double loyaltyPoints;  // The number of loyalty points awarded or redeemed
    private String transactionId;  // An identifier for the transaction (optional, for correlation with other events)
    private String description;    // A description of the action that triggered the points update (e.g., "purchase", "bonus")

}
