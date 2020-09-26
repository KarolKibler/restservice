
package pl.coderslab.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.rest.domain.Book;
import pl.coderslab.rest.domain.MockBookList;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/books")
public class BookService {

    private final List<Book> books = MockBookList.getInstance();

    @GetMapping("")
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        Optional<Book> match = books.stream().filter(c -> c.getId() == id).findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        MockBookList.addBook(book);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        int index = books.indexOf(book);
        if(index >=0)
            books.set(index,book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        Predicate<Book> book = b -> b.getId() == id;
        books.removeIf(book);
    }
}
