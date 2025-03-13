package matt.book.data.client.call.search;

import com.google.gson.Gson;
import matt.book.data.client.message.search.SearchBooksByBookTagsRequest;
import matt.book.data.client.message.search.SearchBooksByBookTagsResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static matt.book.data.client.constants.Constants.SEARCH_BOOKS_BY_BOOK_TAGS;

public class SearchBooksByBookTagsCall {
  private HttpClient httpClient;
  private Gson gson;

  public SearchBooksByBookTagsCall(HttpClient httpClient, Gson gson) {
    this.httpClient = httpClient;
    this.gson = gson;
  }
  public SearchBooksByBookTagsCall() {
    this.httpClient = HttpClient.newHttpClient();
    this.gson = new Gson();
  }

  public SearchBooksByBookTagsResponse searchBooksByBookTags(
    SearchBooksByBookTagsRequest searchBooksByBookTagsRequest,
    String authToken
  ) throws IOException, InterruptedException {
    HttpRequest httpRequest = HttpRequest.newBuilder()
      .uri(URI.create(SEARCH_BOOKS_BY_BOOK_TAGS))
      .header("Content-Type", "Application/json")
      .header("Authorization", authToken)
      .POST(BodyPublishers.ofString(gson.toJson(searchBooksByBookTagsRequest)))
      .build();
    HttpResponse<String> httpResponse = httpClient.send(
      httpRequest, BodyHandlers.ofString());
    String httpResponseBodyString = httpResponse.body();
    return gson.fromJson(httpResponseBodyString, SearchBooksByBookTagsResponse.class);
  }
}
