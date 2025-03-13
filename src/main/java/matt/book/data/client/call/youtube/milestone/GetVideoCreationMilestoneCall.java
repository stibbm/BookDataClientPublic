package matt.book.data.client.call.youtube.milestone;

import com.google.gson.Gson;
import matt.book.data.client.message.youtube.milestone.GetVideoCreationMilestoneRequest;
import matt.book.data.client.message.youtube.milestone.GetVideoCreationMilestoneResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static matt.book.data.client.constants.Constants.GET_VIDEO_CREATION_MILESTONE;

public class GetVideoCreationMilestoneCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetVideoCreationMilestoneCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetVideoCreationMilestoneCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetVideoCreationMilestoneResponse call(
        GetVideoCreationMilestoneRequest request,
        String authToken
    ) throws IOException, InterruptedException {
        System.out.println("getVideoCreationMilestoneRequest: " + request);
        System.out.println("getAuthToken: " + authToken);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(GET_VIDEO_CREATION_MILESTONE))
                .header("Content-Type", "Application/json")
                .header("Authorization", authToken)
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(request)))
                .build();
        System.out.println("HttpRequest: ");
        System.out.println(httpRequest);
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetVideoCreationMilestoneResponse.class);
    }
}
