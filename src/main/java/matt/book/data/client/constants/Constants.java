package matt.book.data.client.constants;

import com.google.gson.Gson;

public class Constants {
    public static String BASE_URL = "http://localhost:9190";

    public static final String CREATE_BOOK = BASE_URL + "/createBook";
    public static final String CREATE_CHAPTER = BASE_URL + "/createChapter";
    public static final String CREATE_IMAGE = BASE_URL + "/createImage";

    public static final String CREATE_BOOK_VIEW = BASE_URL + "/createBookView";
    public static final String GET_BOOK_VIEWS_BY_BOOK_NAME = BASE_URL + "/getBookViewsByBookNumber";

    public static final String GET_ALL_BOOKS_PAGED = BASE_URL + "/getAllBooksPaged";
    public static final String GET_ALL_BOOKS_SORTED_PAGED = BASE_URL + "/getAllBooksSortedPaged";
    public static final String GET_BOOK_BY_BOOK_NAME = BASE_URL + "/getBookByBookName";
    public static final String GET_BOOK_BY_BOOK_NAME_BATCHED = BASE_URL + "/getBookByBookNameBatched";
    public static final String GET_BOOK_BY_BOOK_NUMBER = BASE_URL + "/getBookByBookNumber";

    public static final String GET_CHAPTERS_BY_BOOK_NAME_PAGED = BASE_URL + "/getChaptersByBookNamePaged";
    public static final String GET_CHAPTER_BY_BOOK_NAME_AND_CHAPTER_NUMBER =
            BASE_URL + "/getChapterByBookNameAndChapterNumber";
    public static final String GET_CHAPTER_HEADERS_BY_BOOK_NUMBER = BASE_URL + "/getChapterHeadersByBookNumber";

    public static final String GET_IMAGES_BY_BOOK_NAME_AND_CHAPTER_NUMBER_PAGED =
            BASE_URL + "/getImagesByBookNameAndChapterNumberPaged";
    public static final String GET_IMAGE_BY_BOOK_NAME_AND_CHAPTER_NUMBER_AND_IMAGE_NUMBER =
            BASE_URL + "/getImageByBookNameAndChapterNumberAndImageNumber";

    public static final String CREATE_AUDIO = BASE_URL + "/createAudio";
    public static final String GET_AUDIOS_BY_BOOK_NAME_AND_CHAPTER_NUMBER = BASE_URL + "/getAudiosByBookNameAndChapterNumber";

    public static final String CREATE_TEXT_BLOCK = BASE_URL + "/createTextBlock";
    public static final String GET_TEXT_BLOCK_BY_BOOK_NAME_AND_CHAPTER_NUMBER = BASE_URL + "/getTextBlockByBookNameAndChapterNumber";

    public static final String CREATE_VIDEO = BASE_URL + "/createVideo";
    public static final String GET_VIDEOS_BY_BOOK_NAME_AND_CHAPTER_NUMBER = BASE_URL + "/getVideosByBookNameAndChapterNumber";

    public static final String SEARCH_BOOKS_BY_BOOK_TAGS = BASE_URL + "/searchBooksByBookTags";
    public static final String SEARCH_BOOKS_BY_CONTENT = BASE_URL + "/searchBooksByContent";

    public static final String DELETE_BOOK = BASE_URL + "/deleteBook";

    public static final String CREATE_CHECKOUT_PAGE = BASE_URL + "/createCheckoutPage";
    public static final String GET_CHECKOUT_SESSION_BY_SESSION_ID = BASE_URL + "/getCheckoutSessionBySessionId";
    public static final String GET_STRIPE_CHECKOUT_SESSION_BY_SESSION_ID = BASE_URL + "/getStripeCheckoutSessionBySessionId";

    public static final String CREATE_ACCOUNT = BASE_URL + "/createAccount";
    public static final String GET_ACCOUNT = BASE_URL + "/getAccount";

    public static final String GET_TOKEN_TRANSACTIONS = BASE_URL + "/getTokenTransactions";

    public static final String CREATE_YOUTUBE_VIDEO = BASE_URL + "/createYouTubeVideo";
    public static final String GET_YOUTUBE_VIDEO_BY_YOUTUBE_VIDEO_ID = BASE_URL + "/getYouTubeVideoByYouTubeVideoId";
    public static final String GET_YOUTUBE_VIDEOS_BY_BOOK_NUMBER = BASE_URL + "/getYouTubeVideosByBookNumber";

    public static final String GET_PUBLIC_BOOK_DETAILS_CARD_BY_BOOK_NUMBER = BASE_URL + "/getPublicBookDetailsCardByBookNumber";

    public static final String UPLOAD_TRANSLATED_YOUTUBE_BOOK = BASE_URL + "/uploadTranslatedYoutubeBook";

    public static final String MAKE_TOKEN_PAYMENT = BASE_URL + "/makeTokenPayment";

    public static final String GET_VIDEO_CREATION_MILESTONE = BASE_URL + "/getVideoCreationMilestone";
    public static final String UPDATE_VIDEO_CREATION_MILESTONE = BASE_URL + "/updateVideoCreationMilestone";

    public static final String ALL_ORIGINS = "*";

    public static Gson GSON = new Gson();
}
