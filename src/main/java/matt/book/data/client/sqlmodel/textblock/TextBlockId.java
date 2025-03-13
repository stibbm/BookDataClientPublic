package matt.book.data.client.sqlmodel.textblock;

import java.io.Serializable;
import java.util.Objects;
import matt.book.data.client.sqlmodel.chapter.Chapter;

public class TextBlockId implements Serializable {
    private Long textBlockNumber;

    private Chapter chapter;


    public Long getTextBlockNumber() {return this.textBlockNumber;}
    public Chapter getChapter() {return this.chapter;}

    public void setTextBlockNumber(Long textBlockNumber) {this.textBlockNumber = textBlockNumber;}
    public void setChapter(Chapter chapter) {this.chapter = chapter;}

    public TextBlockId(Long textBlockNumber, Chapter chapter) {
        this.textBlockNumber = textBlockNumber;
        this.chapter = chapter;
    }
    public TextBlockId() {}

    @Override
    public int hashCode() {return Objects.hash(this.chapter, this.textBlockNumber);}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextBlockId that = (TextBlockId) o;
        return this.chapter.equals(that.getChapter()) && this.textBlockNumber.equals(that.getTextBlockNumber());
    }

    @Override
    public String toString() {
        return "TextBlockId{" +
                "chapter=" + chapter +
                ", textBlockNumber=" + textBlockNumber +
                '}';
    }
}
