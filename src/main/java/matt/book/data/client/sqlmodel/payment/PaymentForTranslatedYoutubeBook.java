package matt.book.data.client.sqlmodel.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.VideoCreationMilestone;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentForTranslatedYoutubeBook implements Serializable {
    // have client generate uuid and send it along with the request. It can act as a deduplication token
    private Long paymentNumber;

    private String dedupeId;

    private String translatedYoutubeBookStatus;

    private VideoCreationMilestone videoCreationMilestone;

    private Long tokenTransactionNumber;

    private Long bookNumber;

    private Long startChapter;
    private Long endChapter;

    private String createdBy;
    private Long createdEpochMilli;

    public static PaymentForTranslatedYoutubeBook buildPaymentForTranslatedYoutubeBookWithoutNumber(
            String dedupeId,
            String translatedYoutubeBookStatus,
            VideoCreationMilestone videoCreationMilestone,
            Long tokenTransactionNumber,
            Long bookNumber,
            Long startChapter,
            Long endChapter,
            String createdBy,
            Long createdEpochMilli
    ) {
        PaymentForTranslatedYoutubeBook paymentForTranslatedYoutubeBook = new PaymentForTranslatedYoutubeBook();
        paymentForTranslatedYoutubeBook.setDedupeId(dedupeId);
        paymentForTranslatedYoutubeBook.setTranslatedYoutubeBookStatus(translatedYoutubeBookStatus);
        paymentForTranslatedYoutubeBook.setVideoCreationMilestone(videoCreationMilestone);
        paymentForTranslatedYoutubeBook.setTokenTransactionNumber(tokenTransactionNumber);
        paymentForTranslatedYoutubeBook.setBookNumber(bookNumber);
        paymentForTranslatedYoutubeBook.setStartChapter(startChapter);
        paymentForTranslatedYoutubeBook.setEndChapter(endChapter);
        paymentForTranslatedYoutubeBook.setCreatedBy(createdBy);
        paymentForTranslatedYoutubeBook.setCreatedEpochMilli(createdEpochMilli);
        return paymentForTranslatedYoutubeBook;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PaymentForTranslatedYoutubeBook)) {
            return false;
        }
        PaymentForTranslatedYoutubeBook paymentForTranslatedYoutubeBook = (PaymentForTranslatedYoutubeBook) o;
        return paymentForTranslatedYoutubeBook.getPaymentNumber().equals(this.getPaymentNumber());
    }

    public int hashCode() {
        return this.getPaymentNumber().hashCode();
    }

}
