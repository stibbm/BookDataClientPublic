package matt.book.data.client.message.textblock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import matt.book.data.client.sqlmodel.textblock.TextBlock;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTextBlockResponse implements Serializable {
    private TextBlock textBlock;
}
