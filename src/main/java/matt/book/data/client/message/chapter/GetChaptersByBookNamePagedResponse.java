package matt.book.data.client.message.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.chapter.Chapter;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChaptersByBookNamePagedResponse implements Serializable {
    private List<Chapter> chapterList;
    private int pageNumber;
    private int pageSize;
}
