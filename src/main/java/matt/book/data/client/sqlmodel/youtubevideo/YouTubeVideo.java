package matt.book.data.client.sqlmodel.youtubevideo;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YouTubeVideo implements Serializable {
    private String youtubeVideoId;
    private Long bookNumber;
    private Long startChapterNumber;
    private Long endChapterNumber;
    private String youtubeVideoUrl;

    private String requestedBy;

    private Long createdEpochMilli;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass()!=o.getClass()) {
            return false;
        }
        YouTubeVideo youTubeVideo = (YouTubeVideo) o;
        return Objects.equals(youTubeVideo.getYoutubeVideoId(), youtubeVideoId)
                && Objects.equals(youTubeVideo.getBookNumber(), bookNumber)
                && Objects.equals(youTubeVideo.getStartChapterNumber(), startChapterNumber)
                && Objects.equals(youTubeVideo.getEndChapterNumber(), endChapterNumber)
                && Objects.equals(youTubeVideo.getYoutubeVideoUrl(), youtubeVideoUrl)
                && Objects.equals(youTubeVideo.getRequestedBy(), requestedBy)
                && Objects.equals(youTubeVideo.getCreatedEpochMilli(), createdEpochMilli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(youtubeVideoId);
    }

    public static YouTubeVideo buildYoutubeVideo(
            String youTubeVideoId,
            Long bookNumber,
            Long startChapterNumber,
            Long endChapterNumber,
            String youTubeVideoUrl,
            String requestedBy,
            Long createdEpochMilli
    ) {
        YouTubeVideo youTubeVideo = new YouTubeVideo();
        youTubeVideo.setYoutubeVideoId(youTubeVideoId);
        youTubeVideo.setBookNumber(bookNumber);
        youTubeVideo.setStartChapterNumber(startChapterNumber);
        youTubeVideo.setEndChapterNumber(endChapterNumber);
        youTubeVideo.setYoutubeVideoUrl(youTubeVideoUrl);
        youTubeVideo.setRequestedBy(requestedBy);
        youTubeVideo.setCreatedEpochMilli(createdEpochMilli);
        return youTubeVideo;
    }

}
