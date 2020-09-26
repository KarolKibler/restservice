
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

    private final List<Book> cList = MockBookList.getInstance();

    @GetMapping("")
    public List<Book> getAllBooks() {
        return cList;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        Optional<Book> match = cList.stream().filter(c -> c.getId() == id).findFirst();
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
        cList.remove(book);
        cList.add(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        Predicate<Book> book = b -> b.getId() == id;
        cList.removeIf(book);
    }
}
