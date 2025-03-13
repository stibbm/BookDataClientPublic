package matt.book.data.client.sqlmodel.chapter;

import java.io.Serializable;
import java.util.Objects;
import lombok.ToString;

@ToString
public class Chapter implements Serializable {

    private ChapterId chapterId;
    private String chapterName;
    private Long chapterViews;
    private String createdBy;
    private Long createdEpochMilli;

    public ChapterId getChapterId() {
        return this.chapterId;
    }
    public void setChapterId(ChapterId chapterId) {
        this.chapterId = chapterId;
    }
    public String getChapterName() {
        return this.chapterName;
    }
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public Long getChapterViews() {
        return this.chapterViews;
    }
    public void setChapterViews(Long chapterViews) {
        this.chapterViews = chapterViews;
    }
    public String getCreatedBy(){return this.createdBy;}
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    public Long getCreatedEpochMilli() {return this.createdEpochMilli;}
    public void setCreatedEpochMilli(Long createdEpochMilli) {this.createdEpochMilli = createdEpochMilli;}

    public Chapter(ChapterId chapterId, String chapterName, Long chapterViews, String createdBy, Long createdEpochMilli) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.chapterViews = chapterViews;
        this.createdBy = createdBy;
        this.createdEpochMilli = createdEpochMilli;
    }

    public Chapter() {}

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Chapter chapter = (Chapter)o;
        return Objects.equals(chapter.getChapterId(), chapterId)
                && Objects.equals(chapter.getChapterName(), chapterName)
                && Objects.equals(chapter.getChapterViews(), chapterViews)
                && Objects.equals(chapter.getCreatedBy(), createdBy)
                && Objects.equals(chapter.getCreatedEpochMilli(), createdEpochMilli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                chapterId
        );
    }
}
