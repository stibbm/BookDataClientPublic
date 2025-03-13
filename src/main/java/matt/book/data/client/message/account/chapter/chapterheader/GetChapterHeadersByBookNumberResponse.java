package matt.book.data.client.message.account.chapter.chapterheader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.ChapterHeader;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChapterHeadersByBookNumberResponse implements Serializable {
    private List<ChapterHeader> chapterHeaderList;
}
