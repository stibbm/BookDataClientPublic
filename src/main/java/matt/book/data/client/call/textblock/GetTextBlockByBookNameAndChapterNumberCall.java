package matt.book.data.client.call.textblock;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import matt.book.data.client.message.textblock.GetTextBlockByBookNameAndChapterNumberRequest;
import matt.book.data.client.message.textblock.GetTextBlockByBookNameAndChapterNumberResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_TEXT_BLOCK_BY_BOOK_NAME_AND_CHAPTER_NUMBER;

@Slf4j
@Service
public class GetTextBlockByBookNameAndChapterNumberCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetTextBlockByBookNameAndChapterNumberCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetTextBlockByBookNameAndChapterNumberCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetTextBlockByBookNameAndChapterNumberResponse getTextBlockByBookNameAndChapterNumber(
        GetTextBlockByBookNameAndChapterNumberRequest getTextBlockByBookNameAndChapterNumberRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_TEXT_BLOCK_BY_BOOK_NAME_AND_CHAPTER_NUMBER))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getTextBlockByBookNameAndChapterNumberRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, GetTextBlockByBookNameAndChapterNumberResponse.class);
    }
}
