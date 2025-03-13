package matt.book.data.client.sqlmodel.chapter;

import java.io.Serializable;
import java.util.Objects;
import lombok.ToString;
import matt.book.data.client.sqlmodel.book.Book;

@ToString
public class ChapterId implements Serializable {
    private Long chapterNumber;

    private Book book;

    public Book getBook() {
        return this.book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Long getChapterNumber() {
        return this.chapterNumber;
    }
    public void setChapterNumber(Long chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public ChapterId(Long chapterNumber, Book book) {
        this.chapterNumber = chapterNumber;
        this.book = book;
    }

    public ChapterId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChapterId chapterId = (ChapterId) o;
        return Objects.equals(chapterId.getChapterNumber(), chapterNumber)
                && Objects.equals(chapterId.getBook(), book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterNumber, book);
    }

}
