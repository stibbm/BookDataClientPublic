package matt.book.data.client.message.stripe.session;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.checkoutsession.CheckoutSession;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCheckoutSessionBySessionIdResponse implements Serializable {
    private CheckoutSession checkoutSession;
}
