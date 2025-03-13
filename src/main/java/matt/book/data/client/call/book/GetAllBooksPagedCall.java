package matt.book.data.client.call.book;

import com.google.gson.Gson;
import matt.book.data.client.message.book.GetAllBooksPagedRequest;
import matt.book.data.client.message.book.GetAllBooksPagedResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_ALL_BOOKS_PAGED;

public class GetAllBooksPagedCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetAllBooksPagedCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetAllBooksPagedCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetAllBooksPagedResponse getAllBooksPaged(
        GetAllBooksPagedRequest getAllBooksPagedRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_ALL_BOOKS_PAGED))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getAllBooksPagedRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetAllBooksPagedResponse.class);
    }
}
