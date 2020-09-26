package pl.coderslab.rest.domain;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MockBookList {
  private static final CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();

  private static final AtomicInteger counter = new AtomicInteger(1);

  static {
    books.add(
        new Book(counter.getAndIncrement()
        ,"Java 2. Podstawy"
        ,"9780130819338"
        ,"Cay Horstmann, Gary Cornell"
        ,"Helion"
        ,"programming"
    ));
    books.add(
            new Book(counter.getAndIncrement()
                    ,"C++. Podstawy"
                    ,"0000000000"
                    ,"John"
                    ,"Helion"
                    ,"programming"
            ));
  }

  public static void addBook(Book book){
    book.setId(counter.getAndIncrement());
    books.add(book);
  }
  
  private MockBookList(){}
  
  public static CopyOnWriteArrayList<Book> getInstance(){
    return books;
  }
  
}
