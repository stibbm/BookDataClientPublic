package matt.book.data.client.sqlmodel.book;

import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@ToString
public class Book implements Serializable {

    public Long getBookNumber() {return this.bookNumber;}
    public void setBookNumber(Long bookNumber) {this.bookNumber = bookNumber;}
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookDescription() {
        return this.bookDescription;
    }
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    public String getCreatedBy() {return this.createdBy;}
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    public String getBookLanguage() {
        return this.bookLanguage;
    }
    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }
    public Long getBookViews() {
        return this.bookViews;
    }
    public void setBookViews(Long bookViews) {
        this.bookViews = bookViews;
    }
    public String getBookThumbnail() {
        return this.bookThumbnail;
    }
    public void setBookThumbnail(String bookThumbnail) {
        this.bookThumbnail = bookThumbnail;
    }
    public String getBookThumbnailS3Key() {return this.bookThumbnailS3Key;}
    public void setBookThumbnailS3Key(String bookThumbnailS3Key) {this.bookThumbnailS3Key = bookThumbnailS3Key;}
    public String getBookThumbnailS3Bucket() {return this.bookThumbnailS3Bucket;}
    public void setBookThumbnailS3Bucket(String bookThumbnailS3Bucket) {this.bookThumbnailS3Bucket = bookThumbnailS3Bucket;}
    public Set<String> getBookTags() {
        return this.bookTags;
    }
    public void setBookTags(Set<String> bookTags) {
        this.bookTags = bookTags;
    }
    public Long getCreatedEpochMilli() {
        return this.createdEpochMilli;
    }
    public void setCreatedEpochMilli(Long createdEpochMilli) {
        this.createdEpochMilli = createdEpochMilli;
    }

    public Book(
            Long bookNumber,
            String bookName,
            String bookDescription,
            String createdBy,
            String bookLanguage,
            Long bookViews,
            String bookThumbnail,
            String bookThumbnailS3Key,
            String bookThumbnailS3Bucket,
            Set<String> bookTags,
            Long createdEpochMilli
    ) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.createdBy = createdBy;
        this.bookLanguage = bookLanguage;
        this.bookViews = bookViews;
        this.bookThumbnail = bookThumbnail;
        this.bookThumbnailS3Key = bookThumbnailS3Key;
        this.bookThumbnailS3Bucket = bookThumbnailS3Bucket;
        this.bookTags = bookTags;
        this.createdEpochMilli = createdEpochMilli;
    }

    public Book() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book)o;
        return
                Objects.equals(bookNumber, getBookNumber())
                        && Objects.equals(bookName, book.getBookName())
                        && Objects.equals(bookDescription, book.getBookDescription())
                        && Objects.equals(createdBy, book.getCreatedBy())
                        && Objects.equals(bookViews, book.getBookViews())
                        && Objects.equals(bookLanguage, book.getBookLanguage())
                        && Objects.equals(bookThumbnail, book.getBookThumbnail())
                        && Objects.equals(bookThumbnailS3Key, book.getBookThumbnailS3Key())
                        && Objects.equals(bookThumbnailS3Bucket, book.getBookThumbnailS3Bucket())
                        && Objects.equals(bookTags, book.getBookTags())
                        && Objects.equals(createdEpochMilli, book.getCreatedEpochMilli());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }

    private Long bookNumber;

    private String bookName;

    private String createdBy;

    private String bookDescription;

    private String bookLanguage;

    private Long bookViews;

    private String bookThumbnail;

    private String bookThumbnailS3Key;

    private String bookThumbnailS3Bucket;

    private Set<String> bookTags;

    private Long createdEpochMilli;
}