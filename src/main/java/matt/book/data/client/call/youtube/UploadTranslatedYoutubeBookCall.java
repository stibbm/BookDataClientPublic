package matt.book.data.client.call.youtube;

import com.google.gson.Gson;
import matt.book.data.client.message.youtube.UploadTranslatedYoutubeBookRequest;
import matt.book.data.client.message.youtube.UploadTranslatedYoutubeBookResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.UPLOAD_TRANSLATED_YOUTUBE_BOOK;

public class UploadTranslatedYoutubeBookCall {
    private HttpClient httpClient;
    private Gson gson;
    
    public UploadTranslatedYoutubeBookCall(
            HttpClient httpClient,
            Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public UploadTranslatedYoutubeBookCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public UploadTranslatedYoutubeBookResponse uploadTranslatedYoutubeBook(
            UploadTranslatedYoutubeBookRequest uploadTranslatedYoutubeBookRequest,
            String authToken) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(UPLOAD_TRANSLATED_YOUTUBE_BOOK))
                .header("Content-Type", "Application/Json")
                .header("Authorization", authToken)
                .POST(BodyPublishers.ofString(gson.toJson(uploadTranslatedYoutubeBookRequest)))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, UploadTranslatedYoutubeBookResponse.class);
    }
}
