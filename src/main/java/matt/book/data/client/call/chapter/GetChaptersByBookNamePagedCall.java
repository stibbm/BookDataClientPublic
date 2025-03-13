package matt.book.data.client.call.chapter;

import com.google.gson.Gson;
import matt.book.data.client.message.chapter.GetChaptersByBookNamePagedRequest;
import matt.book.data.client.message.chapter.GetChaptersByBookNamePagedResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_CHAPTERS_BY_BOOK_NAME_PAGED;

public class GetChaptersByBookNamePagedCall {

    private HttpClient httpClient;
    private Gson gson;

    public GetChaptersByBookNamePagedCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetChaptersByBookNamePagedCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetChaptersByBookNamePagedResponse getChaptersByBookNamePaged(
        GetChaptersByBookNamePagedRequest getChaptersByBookNamePagedRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_CHAPTERS_BY_BOOK_NAME_PAGED))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getChaptersByBookNamePagedRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetChaptersByBookNamePagedResponse.class);
    }

}
