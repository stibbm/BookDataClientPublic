package matt.book.data.client.call.bookview;

import com.google.gson.Gson;
import matt.book.data.client.message.bookview.CreateBookViewRequest;
import matt.book.data.client.message.bookview.CreateBookViewResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_BOOK_VIEW;

public class CreateBookViewCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateBookViewCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateBookViewCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateBookViewResponse createBookView(
        CreateBookViewRequest createBookViewRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_BOOK_VIEW))
            .header("Content-Type", "Application/Json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createBookViewRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateBookViewResponse.class);
    }

}
