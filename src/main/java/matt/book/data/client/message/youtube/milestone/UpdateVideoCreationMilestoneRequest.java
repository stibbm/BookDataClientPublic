package matt.book.data.client.message.youtube.milestone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.model.VideoCreationMilestone;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVideoCreationMilestoneRequest implements Serializable {
    private VideoCreationMilestone videoCreationMilestone;
    private String bookNumber;
    private String endChapterNumber;
    private String startChapterNumber;

}
