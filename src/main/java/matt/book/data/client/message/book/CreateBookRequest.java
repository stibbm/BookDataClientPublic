package matt.book.data.client.message.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest implements Serializable {
    private String bookName;
    private String bookDescription;
    private String bookLanguage;
    private String bookViews;
    private Set<String> bookTags;
    private byte[] bookThumbnailImageBytes;
    private String fileType;
}
