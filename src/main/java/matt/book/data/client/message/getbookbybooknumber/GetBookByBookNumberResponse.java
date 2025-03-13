package matt.book.data.client.message.getbookbybooknumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.book.Book;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBookByBookNumberResponse implements Serializable {
    private Book book;
}
