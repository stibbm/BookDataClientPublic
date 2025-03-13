package matt.book.data.client.message.youtube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateYouTubeVideoRequest implements Serializable {
    private String youtubeVideoId;
    private String bookNumber;
    private String startChapterNumber;
    private String endChapterNumber;
}
