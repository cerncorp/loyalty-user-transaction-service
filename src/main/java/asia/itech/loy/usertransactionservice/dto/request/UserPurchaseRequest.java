package asia.itech.loy.usertransactionservice.dto.request;

import jakarta.validation.constraints.Positive;

public record UserPurchaseRequest(
        @Positive Long userId,
        @Positive Double amount
) {
}
