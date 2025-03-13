package matt.book.data.client.sqlmodel.image;

import java.io.Serializable;
import java.util.Objects;
import lombok.ToString;

@ToString
public class Image implements Serializable {
    private ImageId imageId;

    private String s3Key;
    private String s3Bucket;

    private String relativeImageUrl;
    private String createdBy;
    private String fileType;
    private Long createdEpochMilli;

    public ImageId getImageId() {
        return this.imageId;
    }
    public String getS3Key() {
        return this.s3Key;
    }
    public String getS3Bucket() {
        return this.s3Bucket;
    }
    public String getRelativeImageUrl() {
        return this.relativeImageUrl;
    }
    public String getCreatedBy() {return this.createdBy;}
    public String getFileType() {return this.fileType;}
    public Long getCreatedEpochMilli() {return this.createdEpochMilli;}

    public void setImageId(ImageId imageId) {
        this.imageId = imageId;
    }
    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }
    public void setS3Bucket(String s3Bucket) {
        this.s3Bucket = s3Bucket;
    }
    public void setRelativeImageUrl(String relativeImageUrl) {
        this.relativeImageUrl = relativeImageUrl;
    }
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    public void setFileType(String fileType) {this.fileType = fileType;}
    public void setCreatedEpochMilli(Long createdEpochMilli){this.createdEpochMilli = createdEpochMilli;}

    public Image(
            ImageId imageId,
            String s3Key,
            String s3Bucket,
            String relativeImageUrl,
            String createdBy,
            String fileType,
            Long createdEpochMilli) {
        this.imageId = imageId;
        this.s3Key = s3Key;
        this.s3Bucket = s3Bucket;
        this.relativeImageUrl = relativeImageUrl;
        this.createdBy = createdBy;
        this.fileType = fileType;
        this.createdEpochMilli = createdEpochMilli;
    }

    public Image() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equals(image.getImageId(), imageId)
                && Objects.equals(image.getS3Key(), s3Key)
                && Objects.equals(image.getS3Bucket(), s3Bucket)
                && Objects.equals(image.getRelativeImageUrl(), relativeImageUrl)
                && Objects.equals(image.getCreatedBy(), createdBy)
                && Objects.equals(image.getFileType(), fileType)
                && Objects.equals(image.getCreatedEpochMilli(), createdEpochMilli);
    }

}
