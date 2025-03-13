package matt.book.data.client.call.audio;

import com.google.gson.Gson;
import matt.book.data.client.message.audio.CreateAudioRequest;
import matt.book.data.client.message.audio.CreateAudioResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_AUDIO;

public class CreateAudioCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateAudioCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateAudioCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateAudioResponse createAudio(
        CreateAudioRequest createAudioRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest= HttpRequest.newBuilder()
            .uri(URI.create(CREATE_AUDIO))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createAudioRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateAudioResponse.class);
    }
}
