# Book Data Client

### Create Client Instance
```java
String apiEndpointUrl = "localhost:9090";
BookDataClientSQL bookDataClientSQL = new BookDataClientSQL(apiEndpointUrl);
```

### Create Book
```java
Book createdBook = bookDataClient.createBook(
        "book name",
        "book description",
        "book language",
        "0", // book views as string
        ImmutableList.of("tag1", "tag2"),
        Files.readAllBytes(Path.of("testimage.png")),
        "png",
        "auth token"
);
```

### Create Chapter
```java
Chapter createdChapter = bookDataClient.createChapter(
        createdBook.getBookName(),
        "1", // chapter number 1
        "chapter name",
        "0",
        "auth token"
);
```

### Create Text Block
```java
TextBlock createdTextBlock = bookDataClient.createTextBlock(
        createdBook.getBookName(),
        createdChapter.getChapterId().getChapterNumber().toString(),
        "text block string",
        "auth token"
);
```

### Get Books Sorted and Paged
```java
List<Book> retrievedBookListSortedPaged = bookDataClientSQL.getAllBooksSortedPaged(
        "creationTime", // sort type 
        0, // start page
        1000 // page size
);
```