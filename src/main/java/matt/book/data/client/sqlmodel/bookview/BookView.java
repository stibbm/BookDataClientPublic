package matt.book.data.client.sqlmodel.bookview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookView implements Serializable {
    private Long bookViewNumber;
    private Long bookNumber;
    private String createdBy;
    private Long createdEpochMilli;
}
