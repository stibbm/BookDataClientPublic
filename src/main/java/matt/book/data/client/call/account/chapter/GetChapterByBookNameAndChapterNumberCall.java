package matt.book.data.client.call.account.chapter;

import com.google.gson.Gson;
import matt.book.data.client.message.chapter.GetChapterByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.chapter.GetChapterByBookNameAndChapterNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_CHAPTER_BY_BOOK_NAME_AND_CHAPTER_NUMBER;

public class GetChapterByBookNameAndChapterNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetChapterByBookNameAndChapterNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetChapterByBookNameAndChapterNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetChapterByBookNameAndChapterNumberResponse getChapterByBookNameAndChapterNumber(
        GetChapterByBookNameAndChapterNumberRequest getChapterByBookNameAndChapterNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_CHAPTER_BY_BOOK_NAME_AND_CHAPTER_NUMBER))
            .header("Content-Type", "Application/json")
            .headers("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getChapterByBookNameAndChapterNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetChapterByBookNameAndChapterNumberResponse.class);
    }
}
