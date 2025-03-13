package matt.book.data.client.message.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.searchfilter.SearchTermFilterType;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchBooksByContentRequest implements Serializable {
  private String searchText;
  private SearchTermFilterType searchTermFilterType;
}
