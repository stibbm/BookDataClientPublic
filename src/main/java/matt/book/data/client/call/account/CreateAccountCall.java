package matt.book.data.client.call.account;

import com.google.gson.Gson;
import matt.book.data.client.message.account.CreateAccountRequest;
import matt.book.data.client.message.account.CreateAccountResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.CREATE_ACCOUNT;

public class CreateAccountCall {

    private HttpClient httpClient;
    private Gson gson = new Gson();

    public CreateAccountCall(HttpClient httpClient, Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public CreateAccountCall() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest,
        String authToken) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(CREATE_ACCOUNT))
            .header("Content-Type", "Application/json")
            .header("Authorization", authToken)
            .POST(BodyPublishers.ofString(gson.toJson(createAccountRequest)))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
        String httpResponseString = httpResponse.body();
        return gson.fromJson(httpResponseString, CreateAccountResponse.class);
    }
}
