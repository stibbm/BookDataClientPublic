package matt.book.data.client.call.youtube;

import com.google.gson.Gson;
import matt.book.data.client.message.youtube.GetYouTubeVideosByBookNumberRequest;
import matt.book.data.client.message.youtube.GetYouTubeVideosByBookNumberResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_YOUTUBE_VIDEOS_BY_BOOK_NUMBER;


public class GetYouTubeVideosByBookNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetYouTubeVideosByBookNumberCall(
            HttpClient httpClient,
            Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetYouTubeVideosByBookNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetYouTubeVideosByBookNumberResponse getYouTubeVideosByBookNumber(
            GetYouTubeVideosByBookNumberRequest getYouTubeVideosByBookNumberRequest,
            String authToken) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(GET_YOUTUBE_VIDEOS_BY_BOOK_NUMBER))
                .header("Content-Type", "Application/Json")
                .header("Authorization", authToken)
                .POST(BodyPublishers.ofString(gson.toJson(getYouTubeVideosByBookNumberRequest)))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetYouTubeVideosByBookNumberResponse.class);
    }
}
