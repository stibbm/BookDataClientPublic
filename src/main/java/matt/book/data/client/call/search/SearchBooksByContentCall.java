package matt.book.data.client.call.search;

import com.google.gson.Gson;
import matt.book.data.client.message.search.SearchBooksByContentRequest;
import matt.book.data.client.message.search.SearchBooksByContentResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.SEARCH_BOOKS_BY_CONTENT;

public class SearchBooksByContentCall {
  private HttpClient httpClient;
  private Gson gson;

  public SearchBooksByContentCall(HttpClient httpClient, Gson gson) {
    this.httpClient = httpClient;
    this.gson = gson;
  }

  public SearchBooksByContentCall() {
    this.httpClient = HttpClient.newHttpClient();
    this.gson = new Gson();
  }

  public SearchBooksByContentResponse searchBooksByContent(
    SearchBooksByContentRequest searchBooksByContentRequest,
    String authToken
  ) throws IOException, InterruptedException {
    HttpRequest httpRequest = HttpRequest.newBuilder()
      .uri(URI.create(SEARCH_BOOKS_BY_CONTENT))
      .header("Content-Type", "Application/json")
      .header("Authorization", authToken)
      .POST(BodyPublishers.ofString(gson.toJson(searchBooksByContentRequest)))
      .build();
    HttpResponse<String> httpResponse = httpClient.send(
      httpRequest, BodyHandlers.ofString());
    String httpResponseBodyString = httpResponse.body();
    return gson.fromJson(httpResponseBodyString, SearchBooksByContentResponse.class);
  }
}
