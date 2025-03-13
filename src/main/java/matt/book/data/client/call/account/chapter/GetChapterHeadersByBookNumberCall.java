package matt.book.data.client.call.account.chapter;

import com.google.gson.Gson;
import matt.book.data.client.message.chapter.chapterheader.GetChapterHeadersByBookNumberRequest;
import matt.book.data.client.message.chapter.chapterheader.GetChapterHeadersByBookNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_CHAPTER_HEADERS_BY_BOOK_NUMBER;

public class GetChapterHeadersByBookNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetChapterHeadersByBookNumberCall(HttpClient HttpClient, Gson gson) {
        this.httpClient = HttpClient;
        this.gson = gson;
    }

    public GetChapterHeadersByBookNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetChapterHeadersByBookNumberResponse getChapterHeadersByBookNumber(
        GetChapterHeadersByBookNumberRequest getChapterHeadersByBookNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_CHAPTER_HEADERS_BY_BOOK_NUMBER))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getChapterHeadersByBookNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetChapterHeadersByBookNumberResponse.class);
    }
}
