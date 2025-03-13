package matt.book.data.client.message.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.searchfilter.TagFilterType;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchBooksByBookTagsRequest implements Serializable {
  private List<String> bookTags;
  private TagFilterType tagFilterType;;
}
