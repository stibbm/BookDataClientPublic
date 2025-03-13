package matt.book.data.client.message.youtube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.VideoData;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadTranslatedYoutubeBookRequest implements Serializable {
    private String bookNumber;
    private String startChapterNumber;
    private String endChapterNumber;
    private VideoData videoData;
}
