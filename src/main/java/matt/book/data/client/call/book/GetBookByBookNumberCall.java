package matt.book.data.client.call.book;

import com.google.gson.Gson;
import matt.book.data.client.message.getbookbybooknumber.GetBookByBookNumberRequest;
import matt.book.data.client.message.getbookbybooknumber.GetBookByBookNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_BOOK_BY_BOOK_NUMBER;

public class GetBookByBookNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetBookByBookNumberCall(
            HttpClient httpClient,
            Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetBookByBookNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetBookByBookNumberResponse getBookByBookNumber(
            GetBookByBookNumberRequest getBookByBookNumberRequest,
            String authToken) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(GET_BOOK_BY_BOOK_NUMBER))
                .header("Content-Type", "Application/Json")
                .header("Authorization", authToken)
                .POST(BodyPublishers.ofString(gson.toJson(getBookByBookNumberRequest)))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetBookByBookNumberResponse.class);
    }
}
