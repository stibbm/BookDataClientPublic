package matt.book.data.client.sqlmodel.textblock;

import java.io.Serializable;

public class TextBlock implements Serializable {
    private TextBlockId textBlockId;
    private String textBlockText;
    private String createdBy;
    private Long createdEpochMilli;

    public TextBlock(
            TextBlockId textBlockId,
            String textBlockText,
            String createdBy,
            Long createdEpochMilli) {
        this.textBlockId = textBlockId;
        this.textBlockText = textBlockText;
        this.createdBy = createdBy;
        this.createdEpochMilli = createdEpochMilli;
    }
    public TextBlock(){}

    public TextBlockId getTextBlockId() {return this.textBlockId;}
    public String getTextBlockText() {return this.textBlockText;}
    public String getCreatedBy() {return this.createdBy;}
    public Long getCreatedEpochMilli() {return this.createdEpochMilli;}

    public void setTextBlockId(TextBlockId textBlockId) {this.textBlockId = textBlockId;}
    public void setTextBlockText(String textBlockText) {this.textBlockText = textBlockText;}
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    public void setCreatedEpochMilli(Long createdEpochMilli) {this.createdEpochMilli = createdEpochMilli;}

    @Override
    public int hashCode() {return this.textBlockId.hashCode();}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextBlock that = (TextBlock) o;
        return this.textBlockId.equals(that.getTextBlockId());
    }

    @Override
    public String toString() {
        return "TextBlock{" +
                "textBlockId=" + textBlockId +
                ", textBlockText='" + textBlockText + '\'' +
                '}';
    }

}
