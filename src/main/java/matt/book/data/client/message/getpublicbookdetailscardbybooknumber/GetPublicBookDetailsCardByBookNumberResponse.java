package matt.book.data.client.message.getpublicbookdetailscardbybooknumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.PublicBookDetailsCard;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPublicBookDetailsCardByBookNumberResponse implements Serializable {
    private PublicBookDetailsCard publicBookDetailsCard;
}
