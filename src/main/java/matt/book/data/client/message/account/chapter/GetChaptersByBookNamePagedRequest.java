package matt.book.data.client.message.account.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChaptersByBookNamePagedRequest implements Serializable {
    private String bookName;
    private String pageNumber;
    private String pageSize;
}
