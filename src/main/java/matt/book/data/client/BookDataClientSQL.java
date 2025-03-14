package matt.book.data.client;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Set;

import matt.book.data.client.call.account.CreateAccountCall;
import matt.book.data.client.call.account.GetAccountCall;
import matt.book.data.client.call.audio.CreateAudioCall;
import matt.book.data.client.call.audio.GetAudiosByBookNameAndChapterNumberCall;
import matt.book.data.client.call.book.CreateBookCall;
import matt.book.data.client.call.book.GetAllBooksPagedCall;
import matt.book.data.client.call.book.GetAllBooksSortedPagedCall;
import matt.book.data.client.call.book.GetBookByBookNameBatchedCall;
import matt.book.data.client.call.book.GetBookByBookNameCall;
import matt.book.data.client.call.book.GetBookByBookNumberCall;
import matt.book.data.client.call.bookview.CreateBookViewCall;
import matt.book.data.client.call.bookview.GetBookViewsByBookNumberCall;
import matt.book.data.client.call.chapter.CreateChapterCall;
import matt.book.data.client.call.chapter.GetChapterByBookNameAndChapterNumberCall;
import matt.book.data.client.call.chapter.GetChapterHeadersByBookNumberCall;
import matt.book.data.client.call.chapter.GetChaptersByBookNamePagedCall;
import matt.book.data.client.call.checkout.CreateCheckoutPageCall;
import matt.book.data.client.call.checkout.GetCheckoutSessionBySessionIdCall;
import matt.book.data.client.call.checkout.GetStripeCheckoutSessionBySessionIdCall;
import matt.book.data.client.call.image.CreateImageCall;
import matt.book.data.client.call.image.GetImagesByBookNameAndChapterNumberCall;
import matt.book.data.client.call.publicbookdetailscard.GetPublicBookDetailsCardByBookNumberCall;
import matt.book.data.client.call.search.SearchBooksByBookTagsCall;
import matt.book.data.client.call.search.SearchBooksByContentCall;
import matt.book.data.client.call.textblock.CreateTextBlockCall;
import matt.book.data.client.call.textblock.GetTextBlockByBookNameAndChapterNumberCall;
import matt.book.data.client.call.tokentransaction.GetTokenTransactionsCall;
import matt.book.data.client.call.tokentransaction.MakePaymentForTranslatedYoutubeBookCall;
import matt.book.data.client.call.video.CreateVideoCall;
import matt.book.data.client.call.video.GetVideosByBookNameAndChapterNumberCall;
import matt.book.data.client.call.youtube.CreateYouTubeVideoCall;
import matt.book.data.client.call.youtube.GetYouTubeVideoByYoutubeVideoIdCall;
import matt.book.data.client.call.youtube.GetYouTubeVideosByBookNumberCall;
import matt.book.data.client.call.youtube.UploadTranslatedYoutubeBookCall;
import matt.book.data.client.call.youtube.milestone.GetVideoCreationMilestoneCall;
import matt.book.data.client.call.youtube.milestone.UpdateVideoCreationMilestoneCall;
import matt.book.data.client.constants.Constants;
import matt.book.data.client.message.account.CreateAccountRequest;
import matt.book.data.client.message.account.CreateAccountResponse;
import matt.book.data.client.message.account.GetAccountResponse;
import matt.book.data.client.message.chapter.CreateChapterRequest;
import matt.book.data.client.message.chapter.CreateChapterResponse;
import matt.book.data.client.message.chapter.GetChapterByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.chapter.GetChapterByBookNameAndChapterNumberResponse;
import matt.book.data.client.message.chapter.GetChaptersByBookNamePagedRequest;
import matt.book.data.client.message.chapter.GetChaptersByBookNamePagedResponse;
import matt.book.data.client.message.audio.CreateAudioRequest;
import matt.book.data.client.message.audio.CreateAudioResponse;
import matt.book.data.client.message.audio.GetAudiosByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.audio.GetAudiosByBookNameAndChapterNumberResponse;
import matt.book.data.client.message.book.CreateBookRequest;
import matt.book.data.client.message.book.CreateBookResponse;
import matt.book.data.client.message.book.GetAllBooksPagedRequest;
import matt.book.data.client.message.book.GetAllBooksPagedResponse;
import matt.book.data.client.message.book.GetBookByBookNameRequest;
import matt.book.data.client.message.book.GetBookByBookNameResponse;
import matt.book.data.client.message.book.allbookssortedpaged.GetAllBooksSortedPagedRequest;
import matt.book.data.client.message.book.allbookssortedpaged.GetAllBooksSortedPagedResponse;
import matt.book.data.client.message.bookview.CreateBookViewRequest;
import matt.book.data.client.message.bookview.CreateBookViewResponse;
import matt.book.data.client.message.bookview.GetBookViewsByBookNumberRequest;
import matt.book.data.client.message.bookview.GetBookViewsByBookNumberResponse;
import matt.book.data.client.message.chapter.chapterheader.GetChapterHeadersByBookNumberRequest;
import matt.book.data.client.message.chapter.chapterheader.GetChapterHeadersByBookNumberResponse;
import matt.book.data.client.message.getbookbybooknumber.GetBookByBookNumberRequest;
import matt.book.data.client.message.getbookbybooknumber.GetBookByBookNumberResponse;
import matt.book.data.client.message.getpublicbookdetailscardbybooknumber.GetPublicBookDetailsCardByBookNumberRequest;
import matt.book.data.client.message.getpublicbookdetailscardbybooknumber.GetPublicBookDetailsCardByBookNumberResponse;
import matt.book.data.client.message.image.CreateImageRequest;
import matt.book.data.client.message.image.CreateImageResponse;
import matt.book.data.client.message.image.GetImagesByBookNameAndChapterNumberPagedRequest;
import matt.book.data.client.message.image.GetImagesByBookNameAndChapterNumberPagedResponse;
import matt.book.data.client.message.search.SearchBooksByBookTagsRequest;
import matt.book.data.client.message.search.SearchBooksByBookTagsResponse;
import matt.book.data.client.message.search.SearchBooksByContentRequest;
import matt.book.data.client.message.search.SearchBooksByContentResponse;
import matt.book.data.client.message.stripe.checkout.CreateCheckoutPageRequest;
import matt.book.data.client.message.stripe.checkout.CreateCheckoutPageResponse;
import matt.book.data.client.message.stripe.session.GetCheckoutSessionBySessionIdRequest;
import matt.book.data.client.message.stripe.session.GetCheckoutSessionBySessionIdResponse;
import matt.book.data.client.message.stripe.session.GetStripeCheckoutSessionBySessionIdRequest;
import matt.book.data.client.message.stripe.session.GetStripeCheckoutSessionBySessionIdResponse;
import matt.book.data.client.message.textblock.CreateTextBlockRequest;
import matt.book.data.client.message.textblock.CreateTextBlockResponse;
import matt.book.data.client.message.textblock.GetTextBlockByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.textblock.GetTextBlockByBookNameAndChapterNumberResponse;
import matt.book.data.client.message.tokentransaction.GetTokenTransactionsResponse;
import matt.book.data.client.message.tokentransaction.MakePaymentForTranslatedYoutubeBookRequest;
import matt.book.data.client.message.tokentransaction.MakePaymentForTranslatedYoutubeBookResponse;
import matt.book.data.client.message.video.CreateVideoRequest;
import matt.book.data.client.message.video.GetVideosByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.video.GetVideosByBookNameAndChapterNumberResponse;
import matt.book.data.client.message.youtube.CreateYouTubeVideoRequest;
import matt.book.data.client.message.youtube.CreateYouTubeVideoResponse;
import matt.book.data.client.message.youtube.GetYouTubeVideoByYouTubeVideoIdRequest;
import matt.book.data.client.message.youtube.GetYouTubeVideoByYouTubeVideoIdResponse;
import matt.book.data.client.message.youtube.GetYouTubeVideosByBookNumberRequest;
import matt.book.data.client.message.youtube.GetYouTubeVideosByBookNumberResponse;
import matt.book.data.client.message.youtube.UploadTranslatedYoutubeBookRequest;
import matt.book.data.client.message.youtube.UploadTranslatedYoutubeBookResponse;
import matt.book.data.client.message.youtube.milestone.GetVideoCreationMilestoneRequest;
import matt.book.data.client.message.youtube.milestone.GetVideoCreationMilestoneResponse;
import matt.book.data.client.message.youtube.milestone.UpdateVideoCreationMilestoneRequest;
import matt.book.data.client.message.youtube.milestone.UpdateVideoCreationMilestoneResponse;
import matt.book.data.client.model.ChapterHeader;
import matt.book.data.client.model.PublicBookDetailsCard;
import matt.book.data.client.model.StripeCheckoutSession;
import matt.book.data.client.model.VideoCreationMilestone;
import matt.book.data.client.model.VideoData;
import matt.book.data.client.sqlmodel.account.Account;
import matt.book.data.client.sqlmodel.audio.Audio;
import matt.book.data.client.sqlmodel.book.Book;
import matt.book.data.client.sqlmodel.bookview.BookView;
import matt.book.data.client.sqlmodel.chapter.Chapter;
import matt.book.data.client.sqlmodel.checkoutsession.CheckoutSession;
import matt.book.data.client.sqlmodel.image.Image;
import matt.book.data.client.sqlmodel.payment.PaymentForTranslatedYoutubeBook;
import matt.book.data.client.sqlmodel.searchfilter.SearchTermFilterType;
import matt.book.data.client.sqlmodel.searchfilter.TagFilterType;
import matt.book.data.client.sqlmodel.textblock.TextBlock;
import matt.book.data.client.sqlmodel.tokentransaction.TokenTransaction;
import matt.book.data.client.sqlmodel.video.Video;
import matt.book.data.client.sqlmodel.youtubevideo.YouTubeVideo;

public class BookDataClientSQL {
	private CreateBookCall createBookCall;
	private GetBookByBookNameCall getBookByBookNameCall;
	private GetBookByBookNameBatchedCall getBookByBookNameBatchedCall;
	private GetBookByBookNumberCall getBookByBookNumberCall;

	private GetAllBooksPagedCall getAllBooksPagedCall;
	private GetAllBooksSortedPagedCall getAllBooksSortedPagedCall;

	private CreateBookViewCall createBookViewCall;
	private GetBookViewsByBookNumberCall getBookViewsByBookNumberCall;

	private CreateChapterCall createChapterCall;
	private GetChaptersByBookNamePagedCall getChaptersByBookNamePagedCall;
	private GetChapterByBookNameAndChapterNumberCall getChapterByBookNameAndChapterNumberCall;

	private CreateImageCall createImageCall;
	private GetImagesByBookNameAndChapterNumberCall getImagesByBookNameAndChapterNumberCall;

	private CreateTextBlockCall createTextBlockCall;
	private GetTextBlockByBookNameAndChapterNumberCall getTextBlocksByBookNameAndChapterNumberCall;

	private CreateAudioCall createAudioCall;
	private GetAudiosByBookNameAndChapterNumberCall getAudiosByBookNameAndChapterNumberCall;

	private CreateVideoCall createVideoCall;
	private GetVideosByBookNameAndChapterNumberCall getVideosByBookNameAndChapterNumberCall;

	private SearchBooksByBookTagsCall searchBooksByBookTagsCall;
	private SearchBooksByContentCall searchBooksByContentCall;

	private CreateAccountCall createAccountCall;
	private GetAccountCall getAccountCall;

	private GetCheckoutSessionBySessionIdCall getCheckoutSessionBySessionIdCall;
	private GetStripeCheckoutSessionBySessionIdCall getStripeCheckoutSessionBySessionIdCall;

	private CreateCheckoutPageCall createCheckoutPageCall;

	private GetTokenTransactionsCall getTokenTransactionsCall;

	private CreateYouTubeVideoCall createYouTubeVideoCall;
	private GetYouTubeVideosByBookNumberCall getYouTubeVideosByBookNumberCall;
	private GetYouTubeVideoByYoutubeVideoIdCall getYouTubeVideoByYoutubeVideoIdCall;

	private GetChapterHeadersByBookNumberCall getChapterHeadersByBookNumberCall;
	private GetPublicBookDetailsCardByBookNumberCall getPublicBookDetailsCardByBookNumberCall;

	private UploadTranslatedYoutubeBookCall uploadTranslatedYoutubeBookCall;

	private MakePaymentForTranslatedYoutubeBookCall makePaymentForTranslatedYoutubeBookCall;

	private UpdateVideoCreationMilestoneCall updateVideoCreationMilestoneCall;
	private GetVideoCreationMilestoneCall getVideoCreationMilestoneCall;


	public BookDataClientSQL(
			CreateBookCall createBookCall,
			GetBookByBookNameCall getBookByBookNameCall,
			GetBookByBookNameBatchedCall getBookByBookNameBatchedCall,
			GetBookByBookNumberCall getBookByBookNumberCall,

			GetAllBooksPagedCall getAllBooksPagedCall,
			GetAllBooksSortedPagedCall getAllBooksSortedPagedCall,

			CreateBookViewCall createBookViewCall,
			GetBookViewsByBookNumberCall getBookViewsByBookNumberCall,

			CreateChapterCall createChapterCall,
			GetChaptersByBookNamePagedCall getChaptersByBookNamePagedCall,
			GetChapterByBookNameAndChapterNumberCall getChapterByBookNameAndChapterNumberCall,

			CreateImageCall createImageCall,
			GetImagesByBookNameAndChapterNumberCall getImagesByBookNameAndChapterNumberCall,

			CreateTextBlockCall createTextBlockCall,
			GetTextBlockByBookNameAndChapterNumberCall getTextBlocksByBookNameAndChapterNumberCall,

			CreateAudioCall createAudioCall,
			GetAudiosByBookNameAndChapterNumberCall getAudiosByBookNameAndChapterNumberCall,

			CreateVideoCall createVideoCall,
			GetVideosByBookNameAndChapterNumberCall getVideosByBookNameAndChapterNumberCall,

			SearchBooksByBookTagsCall searchBooksByBookTagsCall,
			SearchBooksByContentCall searchBooksByContentCall,

			CreateAccountCall createAccountCall,
			GetAccountCall getAccountCall,

			GetCheckoutSessionBySessionIdCall getCheckoutSessionBySessionIdCall,
			GetStripeCheckoutSessionBySessionIdCall getStripeCheckoutSessionBySessionIdCall,
			CreateCheckoutPageCall createCheckoutPageCall,

			GetTokenTransactionsCall getTokenTransactionsCall,

			CreateYouTubeVideoCall createYouTubeVideoCall,
			GetYouTubeVideosByBookNumberCall getYouTubeVideosByBookNumberCall,
			GetYouTubeVideoByYoutubeVideoIdCall getYouTubeVideoByYoutubeVideoIdCall,

			GetChapterHeadersByBookNumberCall getChapterHeadersByBookNumberCall,
			GetPublicBookDetailsCardByBookNumberCall getPublicBookDetailsCardByBookNumberCall,

			UploadTranslatedYoutubeBookCall uploadTranslatedYoutubeBookCall,

			MakePaymentForTranslatedYoutubeBookCall makePaymentForTranslatedYoutubeBookCall,

			UpdateVideoCreationMilestoneCall updateVideoCreationMilestoneCall,
			GetVideoCreationMilestoneCall getVideoCreationMilestoneCall

	) {
		this.createBookCall = createBookCall;
		this.getBookByBookNameCall = getBookByBookNameCall;
		this.getBookByBookNameBatchedCall = getBookByBookNameBatchedCall;
		this.getAllBooksPagedCall = getAllBooksPagedCall;
		this.getAllBooksSortedPagedCall = getAllBooksSortedPagedCall;
		this.createBookViewCall = createBookViewCall;
		this.getBookViewsByBookNumberCall = getBookViewsByBookNumberCall;
		this.createChapterCall = createChapterCall;
		this.getChaptersByBookNamePagedCall = getChaptersByBookNamePagedCall;
		this.getChapterByBookNameAndChapterNumberCall = getChapterByBookNameAndChapterNumberCall;
		this.createImageCall = createImageCall;
		this.getImagesByBookNameAndChapterNumberCall = getImagesByBookNameAndChapterNumberCall;
		this.createTextBlockCall = createTextBlockCall;
		this.getTextBlocksByBookNameAndChapterNumberCall = getTextBlocksByBookNameAndChapterNumberCall;
		this.createAudioCall = createAudioCall;
		this.getAudiosByBookNameAndChapterNumberCall = getAudiosByBookNameAndChapterNumberCall;
		this.createVideoCall = createVideoCall;
		this.getVideosByBookNameAndChapterNumberCall = getVideosByBookNameAndChapterNumberCall;
		this.searchBooksByBookTagsCall = searchBooksByBookTagsCall;
		this.searchBooksByContentCall = searchBooksByContentCall;
		this.createAccountCall = createAccountCall;
		this.getAccountCall = getAccountCall;
		this.getCheckoutSessionBySessionIdCall = getCheckoutSessionBySessionIdCall;
		this.getStripeCheckoutSessionBySessionIdCall = getStripeCheckoutSessionBySessionIdCall;
		this.createCheckoutPageCall = createCheckoutPageCall;
		this.getTokenTransactionsCall = getTokenTransactionsCall;
		this.createYouTubeVideoCall = createYouTubeVideoCall;
		this.getYouTubeVideosByBookNumberCall = getYouTubeVideosByBookNumberCall;
		this.getYouTubeVideoByYoutubeVideoIdCall = getYouTubeVideoByYoutubeVideoIdCall;
		this.getChapterHeadersByBookNumberCall = getChapterHeadersByBookNumberCall;
		this.getPublicBookDetailsCardByBookNumberCall = getPublicBookDetailsCardByBookNumberCall;
		this.uploadTranslatedYoutubeBookCall = uploadTranslatedYoutubeBookCall;
		this.makePaymentForTranslatedYoutubeBookCall = makePaymentForTranslatedYoutubeBookCall;
		this.updateVideoCreationMilestoneCall = updateVideoCreationMilestoneCall;
		this.getVideoCreationMilestoneCall = getVideoCreationMilestoneCall;
	}

	public BookDataClientSQL() {
		this.createBookCall = new CreateBookCall();
		this.getBookByBookNameCall = new GetBookByBookNameCall();
		this.getBookByBookNumberCall = new GetBookByBookNumberCall();
		this.getBookByBookNameBatchedCall = new GetBookByBookNameBatchedCall();
		this.getAllBooksPagedCall = new GetAllBooksPagedCall();
		this.getAllBooksSortedPagedCall = new GetAllBooksSortedPagedCall();
		this.createBookViewCall = new CreateBookViewCall();
		this.getBookViewsByBookNumberCall = new GetBookViewsByBookNumberCall();
		this.createChapterCall = new CreateChapterCall();
		this.getChaptersByBookNamePagedCall = new GetChaptersByBookNamePagedCall();
		this.getChapterByBookNameAndChapterNumberCall = new GetChapterByBookNameAndChapterNumberCall();
		this.createImageCall = new CreateImageCall();
		this.getImagesByBookNameAndChapterNumberCall = new GetImagesByBookNameAndChapterNumberCall();
		this.createTextBlockCall = new CreateTextBlockCall();
		this.getTextBlocksByBookNameAndChapterNumberCall = new GetTextBlockByBookNameAndChapterNumberCall();
		this.createAudioCall = new CreateAudioCall();
		this.getAudiosByBookNameAndChapterNumberCall = new GetAudiosByBookNameAndChapterNumberCall();
		this.createVideoCall = new CreateVideoCall();
		this.getVideosByBookNameAndChapterNumberCall = new GetVideosByBookNameAndChapterNumberCall();
		this.searchBooksByBookTagsCall = new SearchBooksByBookTagsCall();
		this.searchBooksByContentCall = new SearchBooksByContentCall();
		this.createAccountCall = new CreateAccountCall();
		this.getAccountCall = new GetAccountCall();
		this.getCheckoutSessionBySessionIdCall = new GetCheckoutSessionBySessionIdCall();
		this.getStripeCheckoutSessionBySessionIdCall = new GetStripeCheckoutSessionBySessionIdCall();
		this.createCheckoutPageCall = new CreateCheckoutPageCall();
		this.getTokenTransactionsCall = new GetTokenTransactionsCall();
		this.createYouTubeVideoCall = new CreateYouTubeVideoCall();
		this.getYouTubeVideosByBookNumberCall = new GetYouTubeVideosByBookNumberCall();
		this.getYouTubeVideoByYoutubeVideoIdCall = new GetYouTubeVideoByYoutubeVideoIdCall();
		this.getChapterHeadersByBookNumberCall = new GetChapterHeadersByBookNumberCall();
		this.getPublicBookDetailsCardByBookNumberCall = new GetPublicBookDetailsCardByBookNumberCall();
		this.uploadTranslatedYoutubeBookCall = new UploadTranslatedYoutubeBookCall();
		this.makePaymentForTranslatedYoutubeBookCall = new MakePaymentForTranslatedYoutubeBookCall();
		this.updateVideoCreationMilestoneCall = new UpdateVideoCreationMilestoneCall();
		this.getVideoCreationMilestoneCall = new GetVideoCreationMilestoneCall();
	}


	public BookDataClientSQL(String endpointUrl) {
		this();
		Constants.BASE_URL = endpointUrl;
	}

	public Book createBook(
			String bookName,
			String bookDescription,
			String bookLanguage,
			String bookViews,
			Set<String> bookTags,
			byte[] bookThumbnailImageBytes,
			String fileType,
			String authToken) throws IOException, InterruptedException {
		CreateBookRequest createBookRequest = CreateBookRequest.builder()
				.bookName(bookName)
				.bookDescription(bookDescription)
				.bookLanguage(bookLanguage)
				.bookViews(bookViews)
				.bookTags(bookTags)
				.bookThumbnailImageBytes(bookThumbnailImageBytes)
				.fileType(fileType)
				.build();
		CreateBookResponse createBookResponse = createBookCall.createBook(
				createBookRequest,
				authToken);
		return createBookResponse.getBook();
	}

	public Book getBookByBookName(String bookName, String authToken) throws IOException, InterruptedException {
		GetBookByBookNameRequest getBookByBookNameRequest = GetBookByBookNameRequest.builder()
				.bookName(bookName)
				.build();
		GetBookByBookNameResponse getBookByBookNameResponse = getBookByBookNameCall
				.getBookByBookName(getBookByBookNameRequest, authToken);
		return getBookByBookNameResponse.getBook();
	}

	public Book getBookByBookNumber(Long bookNumber, String authToken) throws IOException, InterruptedException {
		GetBookByBookNumberRequest getBookByBookNumberRequest = GetBookByBookNumberRequest.builder()
				.bookNumber(bookNumber).build();
		GetBookByBookNumberResponse getBookByBookNumberResponse = getBookByBookNumberCall.getBookByBookNumber(
				getBookByBookNumberRequest, authToken);
		return getBookByBookNumberResponse.getBook();
	}

	public List<Book> getBookByBookNameBatched(List<String> bookNameList, String authToken)
			throws IOException, InterruptedException {
		List<GetBookByBookNameRequest> getBookByBookNameRequestList = bookNameList.stream().map(bookName -> {
			return GetBookByBookNameRequest.builder()
					.bookName(bookName)
					.build();
		}).toList();
		List<GetBookByBookNameResponse> getBookByBookNameResponseList = getBookByBookNameBatchedCall
				.getBookByBookNameBatched(getBookByBookNameRequestList, authToken);
		return getBookByBookNameResponseList.stream()
				.map(GetBookByBookNameResponse::getBook)
				.toList();
	}

	public List<Book> getAllBooksPaged(
			int pageNumber,
			int pageSize,
			String authToken) throws IOException, InterruptedException {
		GetAllBooksPagedRequest getAllBooksPagedRequest = GetAllBooksPagedRequest.builder()
				.pageNumber("" + pageNumber)
				.pageSize("" + pageSize)
				.build();
		GetAllBooksPagedResponse getAllBooksPagedResponse = getAllBooksPagedCall
				.getAllBooksPaged(getAllBooksPagedRequest, authToken);
		return getAllBooksPagedResponse.getBookList();
	}

	public List<Book> getAllBooksSortedPaged(
			String bookSortType,
			int pageNumber,
			int pageSize,
			String authToken) throws IOException, InterruptedException {
		GetAllBooksSortedPagedRequest getAllBooksSortedPagedRequest = GetAllBooksSortedPagedRequest
				.builder()
				.sortType(bookSortType)
				.pageNumber("" + pageNumber)
				.pageSize("" + pageSize)
				.build();
		GetAllBooksSortedPagedResponse getAllBooksSortedPagedResponse = getAllBooksSortedPagedCall
				.getAllBooksSortedPaged(getAllBooksSortedPagedRequest, authToken);
		return getAllBooksSortedPagedResponse.getBookList();
	}

	public BookView createBookView(
			String bookNumber,
			String authToken) throws IOException, InterruptedException {
		CreateBookViewRequest createBookViewRequest = CreateBookViewRequest.builder()
				.bookNumber(bookNumber)
				.build();
		CreateBookViewResponse createBookViewResponse = createBookViewCall.createBookView(
				createBookViewRequest, authToken);
		return createBookViewResponse.getBookView();
	}

	public List<BookView> getBookViewsByBookNumber(String bookNumber, String authToken)
			throws IOException, InterruptedException {
		GetBookViewsByBookNumberRequest getBookViewsByBookNumberRequest = GetBookViewsByBookNumberRequest.builder()
				.bookNumber(bookNumber)
				.build();
		GetBookViewsByBookNumberResponse getBookViewsByBookNumberResponse = getBookViewsByBookNumberCall
				.getBookViewsByBookNumber(getBookViewsByBookNumberRequest, authToken);
		return getBookViewsByBookNumberResponse.getBookViewList();
	}

	public Chapter createChapter(
			String bookName,
			String chapterNumber,
			String chapterName,
			String chapterViews,
			String authToken) throws IOException, InterruptedException {
		CreateChapterRequest createChapterRequest = CreateChapterRequest.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.chapterName(chapterName)
				.chapterViews(chapterViews)
				.build();
		CreateChapterResponse createChapterResponse = createChapterCall
				.createChapter(createChapterRequest, authToken);
		return createChapterResponse.getChapter();
	}

	public List<Chapter> getChaptersByBookNamePaged(
			String bookName,
			int pageNumber,
			int pageSize,
			String authToken) throws IOException, InterruptedException {
		GetChaptersByBookNamePagedRequest getChaptersByBookNamePagedRequest = GetChaptersByBookNamePagedRequest
				.builder()
				.bookName(bookName)
				.pageNumber("" + pageNumber)
				.pageSize("" + pageSize)
				.build();
		GetChaptersByBookNamePagedResponse getChaptersByBookNamePagedResponse = getChaptersByBookNamePagedCall
				.getChaptersByBookNamePaged(
						getChaptersByBookNamePagedRequest, authToken);
		return getChaptersByBookNamePagedResponse.getChapterList();
	}

	public Chapter getChapterByBookNameAndChapterNumber(
			String bookName,
			String chapterNumber,
			String authToken) throws IOException, InterruptedException {
		GetChapterByBookNameAndChapterNumberRequest getChapterByBookNameAndChapterNumberRequest = GetChapterByBookNameAndChapterNumberRequest
				.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.build();
		GetChapterByBookNameAndChapterNumberResponse getChapterByBookNameAndChapterNumberResponse = getChapterByBookNameAndChapterNumberCall
				.getChapterByBookNameAndChapterNumber(
						getChapterByBookNameAndChapterNumberRequest, authToken);
		return getChapterByBookNameAndChapterNumberResponse.getChapter();
	}

	public Image createImage(
			String bookName,
			String chapterNumber,
			String imageNumber,
			byte[] imageFileBytes,
			String fileType,
			String authToken) throws IOException, InterruptedException {
		CreateImageRequest createImageRequest = CreateImageRequest.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.imageNumber(imageNumber)
				.fileBytes(imageFileBytes)
				.fileType(fileType)
				.build();
		CreateImageResponse createImageResponse = createImageCall.createImage(
				createImageRequest, authToken);
		return createImageResponse.getImage();
	}

	public List<Image> getImagesByBookNameAndChapterNumber(
			String bookName,
			String chapterNumber,
			int pageNumber,
			int pageSize,
			String authToken) throws IOException, InterruptedException {
		GetImagesByBookNameAndChapterNumberPagedRequest getImagesByBookNameAndChapterNumberPagedRequest = GetImagesByBookNameAndChapterNumberPagedRequest
				.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.pageNumber("" + pageNumber)
				.pageSize("" + pageSize)
				.build();
		GetImagesByBookNameAndChapterNumberPagedResponse getImagesByBookNameAndChapterNumberPagedResponse = getImagesByBookNameAndChapterNumberCall
				.getImagesByBookNameAndChapterNumberPaged(
						getImagesByBookNameAndChapterNumberPagedRequest, authToken);
		return getImagesByBookNameAndChapterNumberPagedResponse.getImageList();
	}

	public TextBlock createTextBlock(
			String bookName,
			String chapterNumber,
			String textBlockText,
			String authToken) throws IOException, InterruptedException {
		CreateTextBlockRequest createTextBlockRequest = CreateTextBlockRequest.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.textBlockText(textBlockText)
				.build();
		CreateTextBlockResponse createTextBlockResponse = createTextBlockCall.createTextBlock(
				createTextBlockRequest, authToken);
		return createTextBlockResponse.getTextBlock();
	}

	public TextBlock getTextBlockByBookNameAndChapterNumber(
			String bookName,
			String chapterNumber,
			String authToken) throws IOException, InterruptedException {
		GetTextBlockByBookNameAndChapterNumberRequest getTextBlockByBookNameAndChapterNumberRequest = GetTextBlockByBookNameAndChapterNumberRequest
				.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.build();
		GetTextBlockByBookNameAndChapterNumberResponse getTextBlockByBookNameAndChapterNumberResponse = getTextBlocksByBookNameAndChapterNumberCall
				.getTextBlockByBookNameAndChapterNumber(
						getTextBlockByBookNameAndChapterNumberRequest, authToken);
		return getTextBlockByBookNameAndChapterNumberResponse.getTextBlock();
	}

	public Audio createAudio(
			String bookName,
			String chapterNumber,
			String audioNumber,
			byte[] fileBytes,
			String fileType,
			String authToken) throws IOException, InterruptedException {
		CreateAudioRequest createAudioRequest = CreateAudioRequest.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.audioNumber(audioNumber)
				.fileBytes(fileBytes)
				.fileType(fileType)
				.build();
		CreateAudioResponse createAudioResponse = createAudioCall.createAudio(
				createAudioRequest, authToken);
		return createAudioResponse.getAudio();
	}

	public List<Audio> getAudiosByBookNameAndChapterNumber(
			String bookName,
			String chapterNumber,
			String authToken) throws IOException, InterruptedException {
		GetAudiosByBookNameAndChapterNumberRequest getAudiosByBookNameAndChapterNumberRequest = GetAudiosByBookNameAndChapterNumberRequest
				.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.build();
		GetAudiosByBookNameAndChapterNumberResponse getAudiosByBookNameAndChapterNumberResponse = getAudiosByBookNameAndChapterNumberCall
				.getAudiosByBookNameAndChapterNumber(
						getAudiosByBookNameAndChapterNumberRequest,
						authToken);
		return getAudiosByBookNameAndChapterNumberResponse.getAudioList();
	}

	public Video createVideo(
			String bookName,
			String chapterNumber,
			String videoNumber,
			byte[] fileBytes,
			String fileType,
			String authToken) throws IOException, InterruptedException {
		CreateVideoRequest createVideoRequest = CreateVideoRequest.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.videoNumber(videoNumber)
				.videoBytes(fileBytes)
				.fileType(fileType)
				.build();
		return createVideoCall.createVideo(createVideoRequest, authToken).getVideo();
	}

	public List<Video> getVideosByBookNameAndChapterNumber(
			String bookName,
			String chapterNumber,
			String authToken) throws IOException, InterruptedException {
		GetVideosByBookNameAndChapterNumberRequest getVideosByBookNameAndChapterNumberRequest = GetVideosByBookNameAndChapterNumberRequest
				.builder()
				.bookName(bookName)
				.chapterNumber(chapterNumber)
				.build();
		GetVideosByBookNameAndChapterNumberResponse getVideosByBookNameAndChapterNumberResponse = getVideosByBookNameAndChapterNumberCall
				.getVideosByBookNameAndChapterNumber(
						getVideosByBookNameAndChapterNumberRequest, authToken);
		return getVideosByBookNameAndChapterNumberResponse.getVideoList();
	}

	public List<Book> searchBooksByBookTags(
			List<String> bookTags,
			TagFilterType tagFilterType,
			String authToken) throws IOException, InterruptedException {
		SearchBooksByBookTagsRequest searchBooksByBookTagsRequest = SearchBooksByBookTagsRequest.builder()
				.bookTags(bookTags)
				.tagFilterType(tagFilterType)
				.build();
		SearchBooksByBookTagsResponse searchBooksByBookTagsResponse = searchBooksByBookTagsCall
				.searchBooksByBookTags(searchBooksByBookTagsRequest, authToken);
		return searchBooksByBookTagsResponse.getBookList();
	}

	public List<Book> searchBooksByContent(String searchInput, SearchTermFilterType searchTermFilterType,
			String authToken)
			throws IOException, InterruptedException {
		SearchBooksByContentRequest searchBooksByContentRequest = SearchBooksByContentRequest.builder()
				.searchText(searchInput)
				.searchTermFilterType(searchTermFilterType)
				.build();
		SearchBooksByContentResponse searchBooksByContentResponse = searchBooksByContentCall
				.searchBooksByContent(searchBooksByContentRequest, authToken);
		return searchBooksByContentResponse.getBookList();
	}

	public Account createAccount(String fullName, String authToken)
			throws IOException, InterruptedException {
		CreateAccountRequest createAccountRequest = CreateAccountRequest.builder()
				.fullName(fullName)
				.build();
		CreateAccountResponse createAccountResponse = createAccountCall.createAccount(
				createAccountRequest, authToken);
		return createAccountResponse.getAccount();
	}

	public Account getAccount(String authToken) throws IOException, InterruptedException {
		GetAccountResponse getAccountResponse = getAccountCall.getAccount(authToken);
		return getAccountResponse.getAccount();
	}

	public String createCheckoutPage(String itemName, String baseUrl, String authToken)
			throws IOException, InterruptedException {
		CreateCheckoutPageRequest createCheckoutPageRequest = CreateCheckoutPageRequest.builder()
				.itemName(itemName)
				.baseUrl(baseUrl)
				.build();
		CreateCheckoutPageResponse createCheckoutPageResponse = createCheckoutPageCall
				.createCheckoutPage(createCheckoutPageRequest, authToken);
		return createCheckoutPageResponse.getCheckoutPageUrl();
	}

	public CheckoutSession getCheckoutSessionBySessionId(String sessionId, String authToken)
			throws IOException, InterruptedException {
		GetCheckoutSessionBySessionIdRequest getCheckoutSessionBySessionIdRequest = GetCheckoutSessionBySessionIdRequest
				.builder().sessionId(sessionId).build();
		GetCheckoutSessionBySessionIdResponse getCheckoutSessionBySessionIdResponse = getCheckoutSessionBySessionIdCall
				.getCheckoutBySessionId(getCheckoutSessionBySessionIdRequest, authToken);
		return getCheckoutSessionBySessionIdResponse.getCheckoutSession();
	}

	public StripeCheckoutSession getStripeCheckoutSessionBySessionId(String sessionId, String authToken)
			throws IOException, InterruptedException {
		GetStripeCheckoutSessionBySessionIdRequest getStripeCheckoutSessionBySessionIdRequest = GetStripeCheckoutSessionBySessionIdRequest
				.builder()
				.sessionId(sessionId)
				.build();
		GetStripeCheckoutSessionBySessionIdResponse getStripeCheckoutSessionBySessionIdResponse = getStripeCheckoutSessionBySessionIdCall
				.getStripeCheckoutSessionBySessionId(
						getStripeCheckoutSessionBySessionIdRequest, authToken);
		return getStripeCheckoutSessionBySessionIdResponse.getStripeCheckoutSession();
	}

	public List<TokenTransaction> getTokenTransactions(String authToken) throws IOException, InterruptedException {
		GetTokenTransactionsResponse getTokenTransactionsResponse = getTokenTransactionsCall
				.getTokenTransactions(authToken);
		return getTokenTransactionsResponse.getTokenTransactionList();
	}

	public YouTubeVideo createYouTubeVideo(
			String youtubeVideoId,
			String bookNumber,
			String startChapterNumber,
			String endChapterNumber,
			String authToken) throws IOException, InterruptedException {
		CreateYouTubeVideoRequest createYouTubeVideoRequest = CreateYouTubeVideoRequest.builder()
				.youtubeVideoId(youtubeVideoId)
				.bookNumber(bookNumber)
				.startChapterNumber(startChapterNumber)
				.endChapterNumber(endChapterNumber)
				.build();
		CreateYouTubeVideoResponse createYouTubeVideoResponse = createYouTubeVideoCall
				.createYouTubeVideo(createYouTubeVideoRequest, authToken);
		return createYouTubeVideoResponse.getYouTubeVideo();
	}

	public List<YouTubeVideo> getYouTubeVideosByBookNumber(String bookNumber, String authToken)
			throws IOException, InterruptedException {
		GetYouTubeVideosByBookNumberRequest getYouTubeVideosByBookNumberRequest = GetYouTubeVideosByBookNumberRequest
				.builder().bookNumber(bookNumber).build();
		GetYouTubeVideosByBookNumberResponse getYouTubeVideosByBookNumberResponse = getYouTubeVideosByBookNumberCall
				.getYouTubeVideosByBookNumber(getYouTubeVideosByBookNumberRequest, authToken);
		return getYouTubeVideosByBookNumberResponse.getYouTubeVideoList();
	}

	public YouTubeVideo getYouTubeVideo(String youTubeVideoId, String authToken)
			throws IOException, InterruptedException {
		GetYouTubeVideoByYouTubeVideoIdRequest getYouTubeVideoByYouTubeVideoIdRequest = GetYouTubeVideoByYouTubeVideoIdRequest
				.builder().youTubeVideoId(youTubeVideoId).build();
		GetYouTubeVideoByYouTubeVideoIdResponse getYouTubeVideoByYouTubeVideoIdResponse = getYouTubeVideoByYoutubeVideoIdCall
				.getYouTubeVideoByYouTubeVideoId(getYouTubeVideoByYouTubeVideoIdRequest, authToken);
		return getYouTubeVideoByYouTubeVideoIdResponse.getYouTubeVideo();
	}

	public List<ChapterHeader> getChapterHeadersByBookNumber(String bookNumber, String authToken)
			throws IOException, InterruptedException {
		GetChapterHeadersByBookNumberRequest getChapterHeadersByBookNumberRequest = GetChapterHeadersByBookNumberRequest
				.builder().bookNumber(bookNumber).build();
		GetChapterHeadersByBookNumberResponse getChapterHeadersByBookNumberResponse = getChapterHeadersByBookNumberCall
				.getChapterHeadersByBookNumber(getChapterHeadersByBookNumberRequest, authToken);
		return getChapterHeadersByBookNumberResponse.getChapterHeaderList();
	}

	public PublicBookDetailsCard getPublicBookDetailsCardByBookNumber(String bookNumber, String authToken)
			throws IOException, InterruptedException {
		GetPublicBookDetailsCardByBookNumberRequest getPublicBookDetailsCardByBookNumberRequest = GetPublicBookDetailsCardByBookNumberRequest
				.builder().bookNumber(bookNumber).build();
		GetPublicBookDetailsCardByBookNumberResponse getPublicBookDetailsCardByBookNumberResponse = getPublicBookDetailsCardByBookNumberCall
				.getPublicBookDetailsCardByBookNumber(getPublicBookDetailsCardByBookNumberRequest, authToken);
		return getPublicBookDetailsCardByBookNumberResponse.getPublicBookDetailsCard();
	}

	public matt.book.data.client.model.YouTubeVideo uploadTranslatedYoutubeBook(
			String bookNumber,
			String startChapterNumber,
			String endChapterNumber,
			VideoData videoData,
			String authToken) throws IOException, InterruptedException {
		UploadTranslatedYoutubeBookRequest uploadTranslatedYoutubeBookRequest = UploadTranslatedYoutubeBookRequest
				.builder()
				.bookNumber(bookNumber)
				.startChapterNumber(startChapterNumber)
				.endChapterNumber(endChapterNumber)
				.videoData(videoData)
				.build();
		UploadTranslatedYoutubeBookResponse response = uploadTranslatedYoutubeBookCall.uploadTranslatedYoutubeBook(
				uploadTranslatedYoutubeBookRequest,
				authToken);
		return response.getYouTubeVideo();
	}

	public AbstractMap.SimpleEntry<PaymentForTranslatedYoutubeBook, TokenTransaction> makePaymentForTranslatedYoutubeBook(
			String dedupeToken,
			String bookNumber,
			String startChapter,
			String endChapter,
			String tokenAmount,
			String authToken) throws IOException, InterruptedException {
		MakePaymentForTranslatedYoutubeBookRequest makePaymentForTranslatedYoutubeBookRequest = MakePaymentForTranslatedYoutubeBookRequest
				.builder()
				.dedupeToken(dedupeToken)
				.bookNumber(bookNumber)
				.startChapter(startChapter)
				.endChapter(endChapter)
				.tokenAmount(tokenAmount)
				.build();
		MakePaymentForTranslatedYoutubeBookResponse response = makePaymentForTranslatedYoutubeBookCall
				.makePaymentForTranslatedYoutubeBook(makePaymentForTranslatedYoutubeBookRequest, authToken);
		PaymentForTranslatedYoutubeBook paymentForTranslatedYoutubeBook = response.getPayment();
		TokenTransaction tokenTransaction = response.getTransaction();
		AbstractMap.SimpleEntry<PaymentForTranslatedYoutubeBook, TokenTransaction> paymentAndTransaction = new AbstractMap.SimpleEntry<>(
				paymentForTranslatedYoutubeBook, tokenTransaction);
		return paymentAndTransaction;
	}

	public PaymentForTranslatedYoutubeBook updateVideoCreationMilestone(
			VideoCreationMilestone videoCreationMilestone,
			String bookNumber,
			String startChapterNumber,
			String endChapterNumber,
			String authToken) throws IOException, InterruptedException {
		UpdateVideoCreationMilestoneRequest updateVideoCreationMilestoneRequest = UpdateVideoCreationMilestoneRequest
				.builder()
				.videoCreationMilestone(videoCreationMilestone)
				.bookNumber(bookNumber)
				.startChapterNumber(startChapterNumber)
				.endChapterNumber(endChapterNumber)
				.build();
		UpdateVideoCreationMilestoneResponse updateVideoCreationMilestoneResponse = updateVideoCreationMilestoneCall
				.call(updateVideoCreationMilestoneRequest, authToken);
		PaymentForTranslatedYoutubeBook paymentForTranslatedYoutubeBook = updateVideoCreationMilestoneResponse
				.getPaymentForTranslatedYoutubeBook();
		return paymentForTranslatedYoutubeBook;
	}

	public VideoCreationMilestone getVideoCreationMilestone(
			String bookNumber,
			String startChapterNumber,
			String endChapterNumber,
			String authToken) throws IOException, InterruptedException {
		GetVideoCreationMilestoneRequest getVideoCreationMilestoneRequest = GetVideoCreationMilestoneRequest
				.builder().bookNumber(bookNumber).startChapterNumber(startChapterNumber)
				.endChapterNumber(endChapterNumber).build();
		GetVideoCreationMilestoneResponse getVideoCreationMilestoneResponse = getVideoCreationMilestoneCall
				.call(getVideoCreationMilestoneRequest, authToken);
		return getVideoCreationMilestoneResponse.getVideoCreationMilestone();
	}

}
