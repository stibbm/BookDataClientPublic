package matt.book.data.client.call.book;

import com.google.gson.Gson;
import matt.book.data.client.message.book.GetBookByBookNameRequest;
import matt.book.data.client.message.book.GetBookByBookNameResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_BOOK_BY_BOOK_NAME;

public class GetBookByBookNameCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetBookByBookNameCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetBookByBookNameCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetBookByBookNameResponse getBookByBookName(
        GetBookByBookNameRequest getBookByBookNameRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_BOOK_BY_BOOK_NAME))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getBookByBookNameRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetBookByBookNameResponse.class);
    }
}
