package matt.book.data.client.call.audio;

import com.google.gson.Gson;
import matt.book.data.client.message.audio.GetAudiosByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.audio.GetAudiosByBookNameAndChapterNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_AUDIOS_BY_BOOK_NAME_AND_CHAPTER_NUMBER;

public class GetAudiosByBookNameAndChapterNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetAudiosByBookNameAndChapterNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetAudiosByBookNameAndChapterNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetAudiosByBookNameAndChapterNumberResponse getAudiosByBookNameAndChapterNumber(
        GetAudiosByBookNameAndChapterNumberRequest request,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_AUDIOS_BY_BOOK_NAME_AND_CHAPTER_NUMBER))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(request)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseString = httpResponse.body();
        return gson.fromJson(httpResponseString, GetAudiosByBookNameAndChapterNumberResponse.class);
    }
}
