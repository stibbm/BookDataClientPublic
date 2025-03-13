package matt.book.data.client.message.audio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.audio.Audio;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAudiosByBookNameAndChapterNumberResponse implements Serializable {
    private List<Audio> audioList;
}
