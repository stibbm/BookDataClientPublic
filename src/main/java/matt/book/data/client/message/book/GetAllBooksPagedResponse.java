package matt.book.data.client.message.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.book.Book;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBooksPagedResponse implements Serializable {
    private List<Book> bookList;
    private int pageNumber;
    private int pageSize;
}
