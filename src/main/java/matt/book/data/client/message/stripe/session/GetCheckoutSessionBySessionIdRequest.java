package matt.book.data.client.message.stripe.session;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCheckoutSessionBySessionIdRequest implements Serializable {
    private String sessionId;
}
