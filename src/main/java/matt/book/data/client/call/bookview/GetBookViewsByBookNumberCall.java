package matt.book.data.client.call.bookview;

import com.google.gson.Gson;
import matt.book.data.client.message.bookview.GetBookViewsByBookNumberRequest;
import matt.book.data.client.message.bookview.GetBookViewsByBookNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_BOOK_VIEWS_BY_BOOK_NAME;

public class GetBookViewsByBookNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetBookViewsByBookNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetBookViewsByBookNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetBookViewsByBookNumberResponse getBookViewsByBookNumber(
        GetBookViewsByBookNumberRequest getBookViewsByBookNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_BOOK_VIEWS_BY_BOOK_NAME))
            .header("Content-Type", "Application/Json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getBookViewsByBookNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetBookViewsByBookNumberResponse.class);
    }

}
