package matt.book.data.client.call.publicbookdetailscard;

import com.google.gson.Gson;
import matt.book.data.client.message.getpublicbookdetailscardbybooknumber.GetPublicBookDetailsCardByBookNumberRequest;
import matt.book.data.client.message.getpublicbookdetailscardbybooknumber.GetPublicBookDetailsCardByBookNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_PUBLIC_BOOK_DETAILS_CARD_BY_BOOK_NUMBER;

public class GetPublicBookDetailsCardByBookNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetPublicBookDetailsCardByBookNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetPublicBookDetailsCardByBookNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetPublicBookDetailsCardByBookNumberResponse getPublicBookDetailsCardByBookNumber(
        GetPublicBookDetailsCardByBookNumberRequest getPublicBookDetailsCardByBookNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_PUBLIC_BOOK_DETAILS_CARD_BY_BOOK_NUMBER))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getPublicBookDetailsCardByBookNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetPublicBookDetailsCardByBookNumberResponse.class);
    }
}
