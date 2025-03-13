package matt.book.data.client.call.checkout;

import com.google.gson.Gson;
import matt.book.data.client.message.stripe.session.GetStripeCheckoutSessionBySessionIdRequest;
import matt.book.data.client.message.stripe.session.GetStripeCheckoutSessionBySessionIdResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_STRIPE_CHECKOUT_SESSION_BY_SESSION_ID;

public class GetStripeCheckoutSessionBySessionIdCall {
    private HttpClient httpClient;
    private Gson gson;

    public GetStripeCheckoutSessionBySessionIdCall(
        HttpClient httpClient,
        Gson gson
    ) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public GetStripeCheckoutSessionBySessionIdCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public GetStripeCheckoutSessionBySessionIdResponse getStripeCheckoutSessionBySessionId(
        GetStripeCheckoutSessionBySessionIdRequest getStripeCheckoutSessionBySessionIdRequest,
        String authToken
    ) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(GET_STRIPE_CHECKOUT_SESSION_BY_SESSION_ID))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(getStripeCheckoutSessionBySessionIdRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseBodyString  = httpResponse.body();
        GetStripeCheckoutSessionBySessionIdResponse getStripeCheckoutSessionBySessionIdResponse =
            gson.fromJson(httpResponseBodyString, GetStripeCheckoutSessionBySessionIdResponse.class);
        return getStripeCheckoutSessionBySessionIdResponse;
    }

}
