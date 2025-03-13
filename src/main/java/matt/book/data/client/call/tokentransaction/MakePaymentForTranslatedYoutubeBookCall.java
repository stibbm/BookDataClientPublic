package matt.book.data.client.call.tokentransaction;

import com.google.gson.Gson;
import matt.book.data.client.message.tokentransaction.MakePaymentForTranslatedYoutubeBookRequest;
import matt.book.data.client.message.tokentransaction.MakePaymentForTranslatedYoutubeBookResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import static matt.book.data.client.constants.Constants.MAKE_TOKEN_PAYMENT;

public class MakePaymentForTranslatedYoutubeBookCall {
    private HttpClient httpClient;
    private Gson gson;

    public MakePaymentForTranslatedYoutubeBookCall(HttpClient httpClient, Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public MakePaymentForTranslatedYoutubeBookCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public MakePaymentForTranslatedYoutubeBookResponse makePaymentForTranslatedYoutubeBook(
        MakePaymentForTranslatedYoutubeBookRequest request,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(MAKE_TOKEN_PAYMENT))
            .header("Authorization", authToken)
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(gson.toJson(request)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, MakePaymentForTranslatedYoutubeBookResponse.class);
    }
}
