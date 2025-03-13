package matt.book.data.client.message.stripe.session;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.StripeCheckoutSession;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetStripeCheckoutSessionBySessionIdResponse implements Serializable {
    private StripeCheckoutSession stripeCheckoutSession;
}
