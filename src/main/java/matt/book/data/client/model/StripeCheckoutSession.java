package matt.book.data.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StripeCheckoutSession implements Serializable {
    private String sessionId;
    private String productName;
    private String paymentStatus;
    private String customerId;
    private String sessionStatus;
    private Long totalAmount;
}
