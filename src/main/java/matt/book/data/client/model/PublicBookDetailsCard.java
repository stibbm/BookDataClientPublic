package matt.book.data.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicBookDetailsCard implements Serializable {
    private Book book;
    private Long maxVideo;
    private Long maxTextChapter;
    private Boolean hasEnoughChaptersForNextVideo;
    private NextVideo nextVideo;
    private List<YouTubeVideo> youTubeVideoList;
    private List<Long> textChapterNumberList;
}
