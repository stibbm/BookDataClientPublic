package matt.book.data.client.message.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static software.amazon.awssdk.utils.Validate.notNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateImageRequest implements Serializable {
    private String bookName;
    private String chapterNumber;
    private String imageNumber;
    private byte[] fileBytes;
    private String fileType;

    public void validate() {
        notNull(bookName, "bookName is required");
        notNull(chapterNumber, "chapterNumber is required");
        notNull(imageNumber, "imageNumber is required");
        notNull(fileBytes, "fileBytes is null");
        notNull(fileType, "fileType is null");
    }
}
