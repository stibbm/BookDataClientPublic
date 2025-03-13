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
import java.util.Arrays;
import java.util.List;

import static matt.book.data.client.constants.Constants.GET_BOOK_BY_BOOK_NAME_BATCHED;

public class GetBookByBookNameBatchedCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetBookByBookNameBatchedCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetBookByBookNameBatchedCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public List<GetBookByBookNameResponse> getBookByBookNameBatched(
        List<GetBookByBookNameRequest> getBookByBookNameRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_BOOK_BY_BOOK_NAME_BATCHED))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getBookByBookNameRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        System.out.println(httpResponseBodyString);
        return Arrays.asList(gson.fromJson(httpResponseBodyString, GetBookByBookNameResponse[].class));
    }
}
