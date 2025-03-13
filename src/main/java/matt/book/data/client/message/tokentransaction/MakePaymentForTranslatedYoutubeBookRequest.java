package matt.book.data.client.message.tokentransaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakePaymentForTranslatedYoutubeBookRequest implements Serializable {
    private String dedupeToken;
    private String bookNumber;
    private String startChapter;
    private String endChapter;
    private String tokenAmount;
}
