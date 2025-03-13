package matt.book.data.client.call.video;

import com.google.gson.Gson;
import matt.book.data.client.message.video.CreateVideoRequest;
import matt.book.data.client.message.video.CreateVideoResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_VIDEO;

public class CreateVideoCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateVideoCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateVideoCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateVideoResponse createVideo(
        CreateVideoRequest createVideoRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_VIDEO))
            .header("Content-Type", "application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createVideoRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateVideoResponse.class);
    }
}
