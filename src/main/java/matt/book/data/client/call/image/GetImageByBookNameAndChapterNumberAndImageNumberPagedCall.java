package matt.book.data.client.call.image;

import com.google.gson.Gson;
import matt.book.data.client.message.image.GetImageByBookNameAndChapterNumberAndImageNumberRequest;
import matt.book.data.client.message.image.GetImageByBookNameAndChapterNumberAndImageNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_IMAGE_BY_BOOK_NAME_AND_CHAPTER_NUMBER_AND_IMAGE_NUMBER;

public class GetImageByBookNameAndChapterNumberAndImageNumberPagedCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetImageByBookNameAndChapterNumberAndImageNumberPagedCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetImageByBookNameAndChapterNumberAndImageNumberPagedCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetImageByBookNameAndChapterNumberAndImageNumberResponse getImageByBookNameAndChapterNumberAndImageNumber(
        GetImageByBookNameAndChapterNumberAndImageNumberRequest getImageByBookNameAndChapterNumberAndImageNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_IMAGE_BY_BOOK_NAME_AND_CHAPTER_NUMBER_AND_IMAGE_NUMBER))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getImageByBookNameAndChapterNumberAndImageNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(
            httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetImageByBookNameAndChapterNumberAndImageNumberResponse.class);
    }
}
