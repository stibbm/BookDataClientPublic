package matt.book.data.client.call.tokentransaction;

import com.google.gson.Gson;
import matt.book.data.client.message.tokentransaction.GetTokenTransactionsResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.GET_TOKEN_TRANSACTIONS;

public class GetTokenTransactionsCall {
  private HttpClient httpClient;
  private Gson gson;

  public GetTokenTransactionsCall(HttpClient httpClient, Gson gson) {
    this.httpClient = httpClient;
    this.gson = gson;
  }

  public GetTokenTransactionsCall() {
    this.httpClient = HttpClient.newHttpClient();
    this.gson = new Gson();
  }

  public GetTokenTransactionsResponse getTokenTransactions(String authToken) throws IOException, InterruptedException {
    HttpRequest httpRequest = HttpRequest.newBuilder()
      .uri(URI.create(GET_TOKEN_TRANSACTIONS))
      .header("Authorization", authToken)
      .header("Content-Type", "application/json")
      .POST(BodyPublishers.noBody())
      .build();
    HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
    String httpResponseBodyString = httpResponse.body();
    return gson.fromJson(httpResponseBodyString, GetTokenTransactionsResponse.class);
  }
}
