package matt.book.data.client.call.book;

import com.google.gson.Gson;
import matt.book.data.client.message.book.delete.DeleteBookRequest;
import matt.book.data.client.message.book.delete.DeleteBookResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.DELETE_BOOK;

public class DeleteBookCall {
    private HttpClient httpClient;
    private Gson gson;

    public DeleteBookCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public DeleteBookCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public DeleteBookResponse deleteBook(DeleteBookRequest deleteBookRequest, String authToken)
        throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(DELETE_BOOK))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(deleteBookRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, DeleteBookResponse.class);
    }

}
