package matt.book.data.client.sqlmodel.video;

import java.io.Serializable;
import java.util.Objects;
import matt.book.data.client.sqlmodel.chapter.Chapter;


public class VideoId implements Serializable {
    private Long videoNumber;
    private Chapter chapter;

    public Long getVideoNumber() {
        return this.videoNumber;
    }
    public void setVideoNumber(Long videoNumber) {
        this.videoNumber = videoNumber;
    }

    public Chapter getChapter() {
        return this.chapter;
    }
    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public VideoId(Long videoNumber, Chapter chapter) {
        this.videoNumber = videoNumber;
        this.chapter = chapter;
    }

    public VideoId() {}

    @Override
    public int hashCode() {
        return Objects.hash(this.chapter, this.videoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoId videoId = (VideoId) o;
        return Objects.equals(chapter, videoId.getChapter())
                && Objects.equals(videoNumber, videoId.getVideoNumber());
    }

    public String toString() {
        return "VideoId{" +
                "chapter=" + chapter +
                ", videoNumber=" + videoNumber +
                '}';
    }

}
