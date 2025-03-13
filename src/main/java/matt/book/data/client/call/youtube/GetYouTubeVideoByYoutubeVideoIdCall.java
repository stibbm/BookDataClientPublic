package matt.book.data.client.call.youtube;

import com.google.gson.Gson;
import matt.book.data.client.message.youtube.GetYouTubeVideoByYouTubeVideoIdRequest;
import matt.book.data.client.message.youtube.GetYouTubeVideoByYouTubeVideoIdResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_YOUTUBE_VIDEO_BY_YOUTUBE_VIDEO_ID;

public class GetYouTubeVideoByYoutubeVideoIdCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetYouTubeVideoByYoutubeVideoIdCall(
            HttpClient httpClient,
            Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetYouTubeVideoByYoutubeVideoIdCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetYouTubeVideoByYouTubeVideoIdResponse getYouTubeVideoByYouTubeVideoId(
            GetYouTubeVideoByYouTubeVideoIdRequest getYouTubeVideoByYouTubeVideoIdRequest,
            String authToken) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(GET_YOUTUBE_VIDEO_BY_YOUTUBE_VIDEO_ID))
                .header("Content-Type", "Application/Json")
                .header("Authorization", authToken)
                .POST(BodyPublishers.ofString(gson.toJson(getYouTubeVideoByYouTubeVideoIdRequest)))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetYouTubeVideoByYouTubeVideoIdResponse.class);
    }
}
