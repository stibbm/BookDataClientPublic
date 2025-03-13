package matt.book.data.client.sqlmodel.image;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import matt.book.data.client.sqlmodel.chapter.Chapter;

@Getter
@Setter
@ToString
public class ImageId implements Serializable {
    private Long imageNumber;

    private Chapter chapter;

    public Chapter getChapter() {
        return this.chapter;
    }

    public Long getImageNumber() {
        return this.imageNumber;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setImageNumber(Long imageNumber) {
        this.imageNumber = imageNumber;
    }

    public ImageId(Long imageNumber, Chapter chapter) {
        this.imageNumber = imageNumber;
        this.chapter = chapter;
    }

    public ImageId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageId imageId = (ImageId) o;
        return Objects.equals(imageId.getImageNumber(), imageNumber)
                && Objects.equals(imageId.getChapter(), chapter);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

}
