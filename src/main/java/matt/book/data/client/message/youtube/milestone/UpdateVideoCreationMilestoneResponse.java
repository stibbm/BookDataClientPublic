package matt.book.data.client.message.youtube.milestone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.payment.PaymentForTranslatedYoutubeBook;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVideoCreationMilestoneResponse implements Serializable {
    private PaymentForTranslatedYoutubeBook paymentForTranslatedYoutubeBook;
}
