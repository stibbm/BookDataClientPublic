package matt.book.data.client.message.chapter.chapterheader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChapterHeadersByBookNumberRequest implements Serializable {
    private String bookNumber;
}
