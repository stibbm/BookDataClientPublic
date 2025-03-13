package matt.book.data.client.call.book;


import com.google.gson.Gson;
import matt.book.data.client.message.book.CreateBookRequest;
import matt.book.data.client.message.book.CreateBookResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_BOOK;

public class CreateBookCall {

    private HttpClient httpClient;
    private Gson gson;

    public CreateBookCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateBookCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateBookResponse createBook(
        CreateBookRequest createBookRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_BOOK))
            .header("Content-Type", "Application/Json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createBookRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateBookResponse.class);
    }

}
