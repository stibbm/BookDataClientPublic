package matt.book.data.client.message.bookview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.bookview.BookView;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookViewsByBookNumberResponse implements Serializable {
    private List<BookView> bookViewList;
}
