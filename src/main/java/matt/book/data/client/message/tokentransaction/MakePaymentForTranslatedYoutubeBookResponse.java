package matt.book.data.client.message.tokentransaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.payment.PaymentForTranslatedYoutubeBook;
import matt.book.data.client.sqlmodel.tokentransaction.TokenTransaction;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakePaymentForTranslatedYoutubeBookResponse implements Serializable {
    private PaymentForTranslatedYoutubeBook payment;
    private TokenTransaction transaction;
}
