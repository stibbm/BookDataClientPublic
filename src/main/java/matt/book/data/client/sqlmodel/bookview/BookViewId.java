package matt.book.data.client.sqlmodel.bookview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import matt.book.data.client.sqlmodel.book.Book;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookViewId implements Serializable {

    private Long bookViewNumber;

    private Book book;
}
