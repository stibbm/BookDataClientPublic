package matt.book.data.client.message.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetImageByBookNameAndChapterNumberAndImageNumberRequest implements Serializable {
    private String bookName;
    private String chapterNumber;
    private String imageNumber;
}
