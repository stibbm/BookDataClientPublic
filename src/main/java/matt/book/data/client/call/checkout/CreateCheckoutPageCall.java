package matt.book.data.client.call.checkout;

import com.google.gson.Gson;
import matt.book.data.client.message.stripe.checkout.CreateCheckoutPageRequest;
import matt.book.data.client.message.stripe.checkout.CreateCheckoutPageResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_CHECKOUT_PAGE;

public class CreateCheckoutPageCall {
    private HttpClient httpClient;
    private Gson gson;

    public CreateCheckoutPageCall(HttpClient httpClient, Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateCheckoutPageCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateCheckoutPageResponse createCheckoutPage(
        CreateCheckoutPageRequest createCheckoutPageRequest, String authToken)
        throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_CHECKOUT_PAGE))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createCheckoutPageRequest))).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString = httpResponse.body();
        return gson.fromJson(httpResponseBodyString, CreateCheckoutPageResponse.class);
    }
}
