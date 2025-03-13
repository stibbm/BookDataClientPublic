package matt.book.data.client.message.youtube;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.YouTubeVideo;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadTranslatedYoutubeBookResponse implements Serializable {
  private YouTubeVideo youTubeVideo;
}
