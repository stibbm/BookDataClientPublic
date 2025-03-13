package matt.book.data.client.sqlmodel.video;

import java.io.Serializable;

public class Video implements Serializable {

    private VideoId videoId;

    private String s3Key;
    private String s3Bucket;
    private String relativeUrl;
    private String createdBy;
    private String fileType;
    private Long createdEpochMilli;

    public VideoId getVideoId() {return this.videoId;}
    public String getS3Key() {return this.s3Key;}
    public String getS3Bucket() {return this.s3Bucket;}
    public String getRelativeUrl() {return this.relativeUrl;}
    public String getCreatedBy() {return this.createdBy;}
    public String getFileType() {return this.fileType;}
    public Long getCreatedEpochMilli() {return this.createdEpochMilli;}

    public void setVideoId(VideoId videoId) {this.videoId = videoId;}
    public void setS3Key(String s3Key){this.s3Key = s3Key;}
    public void setS3Bucket(String s3Bucket) {this.s3Bucket = s3Bucket;}
    public void setRelativeUrl(String relativeUrl){this.relativeUrl = relativeUrl;}
    public void setCreatedBy(String createdBy) {this.createdBy = createdBy;}
    public void setFileType(String fileType){this.fileType = fileType;}
    public void setCreatedEpochMilli(){this.createdEpochMilli = createdEpochMilli;}

    public Video(
            VideoId videoId,
            String s3Key,
            String s3Bucket,
            String relativeUrl,
            String createdBy,
            String fileType,
            Long createdEpochMilli
    ) {
        this.videoId = videoId;
        this.s3Key = s3Key;
        this.s3Bucket = s3Bucket;
        this.relativeUrl = relativeUrl;
        this.createdBy = createdBy;
        this.fileType = fileType;
        this.createdEpochMilli = createdEpochMilli;
    }

    public Video() {}

    @Override
    public int hashCode() {
        return this.videoId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Video that = (Video) o;
        return this.videoId.equals(that.getVideoId());
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", s3Key='" + s3Key + '\'' +
                ", s3Bucket='" + s3Bucket + '\'' +
                ", relativeUrl='" + relativeUrl + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdEpochMilli=" + createdEpochMilli +
                '}';
    }

}
