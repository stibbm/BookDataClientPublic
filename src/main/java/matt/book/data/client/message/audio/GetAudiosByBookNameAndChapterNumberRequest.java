package matt.book.data.client.message.audio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAudiosByBookNameAndChapterNumberRequest implements Serializable {
    private String bookName;
    private String chapterNumber;
}
