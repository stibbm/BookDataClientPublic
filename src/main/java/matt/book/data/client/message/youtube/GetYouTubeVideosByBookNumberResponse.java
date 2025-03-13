package matt.book.data.client.message.youtube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.youtubevideo.YouTubeVideo;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetYouTubeVideosByBookNumberResponse implements Serializable {
    private List<YouTubeVideo> youTubeVideoList;
}
