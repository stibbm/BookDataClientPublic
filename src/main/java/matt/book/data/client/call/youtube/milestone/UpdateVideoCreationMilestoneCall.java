package matt.book.data.client.call.youtube.milestone;

import com.google.gson.Gson;
import matt.book.data.client.message.youtube.milestone.UpdateVideoCreationMilestoneRequest;
import matt.book.data.client.message.youtube.milestone.UpdateVideoCreationMilestoneResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static matt.book.data.client.constants.Constants.UPDATE_VIDEO_CREATION_MILESTONE;

public class UpdateVideoCreationMilestoneCall {
    private HttpClient httpClient;
    private Gson gson;

    public UpdateVideoCreationMilestoneCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public UpdateVideoCreationMilestoneCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public UpdateVideoCreationMilestoneResponse call(
        UpdateVideoCreationMilestoneRequest request,
        String authToken
    ) throws IOException, InterruptedException {
        System.out.println("updateVideoCreationMilestone: " + request);
        System.out.println("getAuthToken: " + authToken);
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(UPDATE_VIDEO_CREATION_MILESTONE))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(request)))
            .build();
        System.out.println("HttpRequest: ");
        System.out.println(httpRequest);
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, UpdateVideoCreationMilestoneResponse.class);
    }
}
