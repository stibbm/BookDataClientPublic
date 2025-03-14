package matt.book.data.client;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class TestData {
    public static final String AUTH_TOKEN = "testuser";

    public static final String BOOK_NAME_ONE = "bookNameOneTestValue";
    public static final String BOOK_DESCRIPTION_ONE = "bookDescriptionOne";
    public static final String BOOK_LANGUAGE_ONE = "English";
    public static final String BOOK_VIEWS_ONE = "1";
    public static final String BOOK_THUMBNAIL_ONE = "bookThumbnail";
    public static final Set<String> BOOK_TAGS_ONE = ImmutableSet.of(
            "Action", "Adventure", "Fantasy");

    public static final String BOOK_NAME_TWO = "bookNameTwoTestValue";
    public static final String BOOK_DESCRIPTION_TWO = "bookDescriptionTwo";
    public static final String BOOK_LANGUAGE_TWO = "English";
    public static final String BOOK_VIEWS_TWO = "100";
    public static final String BOOK_THUMBNAIL_TWO = "bookThumbnail2";
    public static final Set<String> BOOK_TAGS_TWO = ImmutableSet.of(
            "Action", "Adventure", "Fantasy");

    public static final String CHAPTER_NUMBER_ONE = "1";
    public static final String CHAPTER_NUMBER_TWO = "2";
    public static final String CHAPTER_NAME_ONE = "chapterNameOne";
    public static final String CHAPTER_NAME_TWO = "cahpterNameTwo";
    public static final String CHAPTER_VIEWS_ONE = "0";

    public static final String IMAGE_NUMBER_ONE = "1";
    public static final String S3_KEY_ONE = "s3KeyOn";
    public static final String S3_BUCKET_ONE = "s3BucketOne";
    public static final String RELATIVE_IMAGE_URL_ONE = "relativeImageUrl";

    public static final String IMAGE_NUMBER_TWO = "2";
    public static final String S3_KEY_TWO = "s3KeyTwo";
    public static final String S3_BUCKET_TWO = "s3BucketTwo";
    public static final String RELATIVE_IMAGE_URL_TWO = "goihewogiw";

    public static final String IMAGE_PATH_ONE = "testImage.png";
    public static final String IMAGE_ONE_FILE_TYPE = "png";
}
