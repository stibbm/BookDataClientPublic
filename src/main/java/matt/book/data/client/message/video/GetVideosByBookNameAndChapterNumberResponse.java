package matt.book.data.client.message.video;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.video.Video;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetVideosByBookNameAndChapterNumberResponse implements Serializable {
    private List<Video> videoList;
}
