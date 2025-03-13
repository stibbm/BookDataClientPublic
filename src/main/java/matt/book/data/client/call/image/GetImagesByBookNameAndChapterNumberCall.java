package matt.book.data.client.call.image;

import com.google.gson.Gson;
import matt.book.data.client.message.image.GetImagesByBookNameAndChapterNumberPagedRequest;
import matt.book.data.client.message.image.GetImagesByBookNameAndChapterNumberPagedResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_IMAGES_BY_BOOK_NAME_AND_CHAPTER_NUMBER_PAGED;

public class GetImagesByBookNameAndChapterNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetImagesByBookNameAndChapterNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetImagesByBookNameAndChapterNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetImagesByBookNameAndChapterNumberPagedResponse getImagesByBookNameAndChapterNumberPaged(
        GetImagesByBookNameAndChapterNumberPagedRequest getImagesByBookNameAndChapterNumberPagedRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_IMAGES_BY_BOOK_NAME_AND_CHAPTER_NUMBER_PAGED))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getImagesByBookNameAndChapterNumberPagedRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetImagesByBookNameAndChapterNumberPagedResponse.class);
    }

}
