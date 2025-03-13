package matt.book.data.client.call.video;

import com.google.gson.Gson;
import matt.book.data.client.message.video.GetVideosByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.video.GetVideosByBookNameAndChapterNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_VIDEOS_BY_BOOK_NAME_AND_CHAPTER_NUMBER;

public class GetVideosByBookNameAndChapterNumberCall {

    private HttpClient httpClient;
    private Gson gson;

    public GetVideosByBookNameAndChapterNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetVideosByBookNameAndChapterNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetVideosByBookNameAndChapterNumberResponse getVideosByBookNameAndChapterNumber(
        GetVideosByBookNameAndChapterNumberRequest getVideosByBookNameAndChapterNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_VIDEOS_BY_BOOK_NAME_AND_CHAPTER_NUMBER))
            .header("Content-Type", "application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getVideosByBookNameAndChapterNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString,
            GetVideosByBookNameAndChapterNumberResponse.class);
    }
}
