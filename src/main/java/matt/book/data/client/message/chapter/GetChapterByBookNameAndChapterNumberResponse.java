package matt.book.data.client.message.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.chapter.Chapter;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChapterByBookNameAndChapterNumberResponse implements Serializable {
    private Chapter chapter;
}
