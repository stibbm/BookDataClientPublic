package matt.book.data.client.sqlmodel.checkoutsession;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckoutSession implements Serializable {

    private Long checkoutSessionNumber;

    private String stripeSessionId;

    private String priceId;

    private String createdBy;

    private Long createdEpochMilli;

    @Override
    public int hashCode() {
        return Objects.hash(checkoutSessionNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) {
            return true;
        }
        if (o==null || this.getClass() != o.getClass()) {
            return false;
        }
        CheckoutSession checkoutSession = (CheckoutSession) o;
        return Objects.equals(checkoutSessionNumber, checkoutSession.getCheckoutSessionNumber())
                && Objects.equals(priceId, checkoutSession.getPriceId())
                && Objects.equals(stripeSessionId, checkoutSession.getStripeSessionId())
                && Objects.equals(createdBy, checkoutSession.getCreatedBy())
                && Objects.equals(createdEpochMilli, checkoutSession.getCreatedEpochMilli());
    }

}
