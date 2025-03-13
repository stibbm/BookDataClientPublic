package matt.book.data.client.call.youtube;

import com.google.gson.Gson;
import matt.book.data.client.message.youtube.CreateYouTubeVideoRequest;
import matt.book.data.client.message.youtube.CreateYouTubeVideoResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_YOUTUBE_VIDEO;

public class CreateYouTubeVideoCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateYouTubeVideoCall(
            HttpClient httpClient,
            Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateYouTubeVideoCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateYouTubeVideoResponse createYouTubeVideo(
        CreateYouTubeVideoRequest createYouTubeVideoRequest,
        String authToken
    ) throws IOException, InterruptedException 
    {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_YOUTUBE_VIDEO))
            .header("Content-Type", "Application/Json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createYouTubeVideoRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateYouTubeVideoResponse.class);
    }
}
