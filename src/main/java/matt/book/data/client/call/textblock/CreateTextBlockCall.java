package matt.book.data.client.call.textblock;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import matt.book.data.client.message.textblock.CreateTextBlockRequest;
import matt.book.data.client.message.textblock.CreateTextBlockResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_TEXT_BLOCK;

@Slf4j
@Service
public class CreateTextBlockCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateTextBlockCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateTextBlockCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateTextBlockResponse createTextBlock(
        CreateTextBlockRequest createTextBlockRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_TEXT_BLOCK))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createTextBlockRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateTextBlockResponse.class);
    }


}
