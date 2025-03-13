package matt.book.data.client.message.youtube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.youtubevideo.YouTubeVideo;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateYouTubeVideoResponse implements Serializable {
    private YouTubeVideo youTubeVideo;
}
