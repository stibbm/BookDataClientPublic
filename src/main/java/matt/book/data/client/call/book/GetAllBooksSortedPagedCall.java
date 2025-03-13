package matt.book.data.client.call.book;

import com.google.gson.Gson;
import matt.book.data.client.message.book.allbookssortedpaged.GetAllBooksSortedPagedRequest;
import matt.book.data.client.message.book.allbookssortedpaged.GetAllBooksSortedPagedResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_ALL_BOOKS_SORTED_PAGED;

public class GetAllBooksSortedPagedCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetAllBooksSortedPagedCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetAllBooksSortedPagedCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetAllBooksSortedPagedResponse getAllBooksSortedPaged(
        GetAllBooksSortedPagedRequest getAllBooksSortedPagedRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_ALL_BOOKS_SORTED_PAGED))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getAllBooksSortedPagedRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseString = httpResponse.body();
        return gson.fromJson(httpResponseString, GetAllBooksSortedPagedResponse.class);
    }
}
