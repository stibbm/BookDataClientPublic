package matt.book.data.client.call.image;

import com.google.gson.Gson;
import matt.book.data.client.message.image.CreateImageRequest;
import matt.book.data.client.message.image.CreateImageResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_IMAGE;

public class CreateImageCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateImageCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateImageCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateImageResponse createImage(
        CreateImageRequest createImageRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_IMAGE))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createImageRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateImageResponse.class);
    }
}
