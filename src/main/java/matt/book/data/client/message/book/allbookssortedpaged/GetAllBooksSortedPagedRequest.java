package matt.book.data.client.message.book.allbookssortedpaged;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBooksSortedPagedRequest implements Serializable {
    private String sortType;
    private String pageNumber;
    private String pageSize;
}
