package matt.book.data.client;

import matt.book.data.client.sqlmodel.book.Book;
import matt.book.data.client.sqlmodel.chapter.Chapter;
import matt.book.data.client.sqlmodel.textblock.TextBlock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static matt.book.data.client.TestData.AUTH_TOKEN;
import static matt.book.data.client.TestData.BOOK_DESCRIPTION_ONE;
import static matt.book.data.client.TestData.BOOK_LANGUAGE_ONE;
import static matt.book.data.client.TestData.BOOK_NAME_ONE;
import static matt.book.data.client.TestData.BOOK_TAGS_ONE;
import static matt.book.data.client.TestData.BOOK_VIEWS_ONE;
import static matt.book.data.client.TestData.CHAPTER_NAME_ONE;
import static matt.book.data.client.TestData.CHAPTER_NUMBER_ONE;
import static matt.book.data.client.TestData.CHAPTER_VIEWS_ONE;
import static matt.book.data.client.TestData.IMAGE_ONE_FILE_TYPE;
import static matt.book.data.client.TestData.IMAGE_PATH_ONE;

@SpringBootApplication
public class BookDataClientPublicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookDataClientPublicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BookDataClientSQL bookDataClientSQL = new BookDataClientSQL();
        Book createdBook = bookDataClientSQL.createBook(
                BOOK_NAME_ONE,
                BOOK_DESCRIPTION_ONE,
                BOOK_LANGUAGE_ONE,
                BOOK_VIEWS_ONE,
                BOOK_TAGS_ONE,
                Files.readAllBytes(Path.of(IMAGE_PATH_ONE)),
                IMAGE_ONE_FILE_TYPE,
                AUTH_TOKEN
        );


        Book retrievedBook = bookDataClientSQL.getBookByBookName(createdBook.getBookName(), AUTH_TOKEN);

        Chapter createdChapter = bookDataClientSQL.createChapter(
                retrievedBook.getBookName(),
                CHAPTER_NUMBER_ONE,
                CHAPTER_NAME_ONE,
                CHAPTER_VIEWS_ONE,
                AUTH_TOKEN
        );
        StringBuilder textBlockText = new StringBuilder("This is a test text block");
        List<String> textChunks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String s = UUID.randomUUID().toString();
            textBlockText.append(s);
            textChunks.add(s);
        }

        String textBlockTextString = textBlockText.toString();
        bookDataClientSQL.createTextBlock(
                retrievedBook.getBookName(),
                createdChapter.getChapterId().getChapterNumber().toString(),
                textBlockTextString,
                AUTH_TOKEN
        );
        TextBlock retrievedTextBlock = bookDataClientSQL.getTextBlockByBookNameAndChapterNumber(
                retrievedBook.getBookName(), createdChapter.getChapterId().getChapterNumber().toString(), AUTH_TOKEN
        );

        List<Book> retrievedBookListSortedPaged = bookDataClientSQL.getAllBooksSortedPaged("creationTime",
                0, 1000, AUTH_TOKEN);

        List<Chapter> chapterList = bookDataClientSQL.getChaptersByBookNamePaged(
                createdBook.getBookName(),
                0,
                10000,
                "auth token"
        );
    }

}
