package BookManagement.Spring.Controller;


import BookManagement.Spring.Entity.BookEntity;
import BookManagement.Spring.Model.BookDTO;
import BookManagement.Spring.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    private Iterable<BookEntity> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    private BookEntity createBook(@RequestBody BookDTO bookDTO){
        BookEntity bookEntity = BookEntity
                .builder()
                .name(bookDTO.getName())
                .price(bookDTO.getPrice())
                .description(bookDTO.getDescription())
                .releaseDate(bookDTO.getReleaseDate())
                .status(bookDTO.getStatus())
                .build();
        return bookService.create(bookEntity);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteBook(@PathVariable int id){
        bookService.remove(id);
        System.out.println("Delete succeeded");
    }
    @PutMapping("/{id}")
    private BookEntity updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO){
        BookEntity bookEntity = bookService.findById(id);
        bookEntity.setName(bookDTO.getName());
        bookEntity.setQuantity(bookDTO.getQuantity());
        bookEntity.setPrice(bookDTO.getPrice());
        bookEntity.setDescription(bookDTO.getDescription());
        bookEntity.setReleaseDate(bookDTO.getReleaseDate());
        bookEntity.setStatus(bookDTO.getStatus());
        return bookService.save(bookEntity);
    }
    @GetMapping("/get/{id}")
    private BookEntity getDetailBook(@PathVariable int id){
        return bookService.findById(id);
    }

    @PutMapping("/sell")
    private ResponseEntity<?> sellBook(@RequestParam int id, @RequestParam int sellQuantity){
        BookEntity bookSold = bookService.sellBook(id,sellQuantity);
        return ResponseEntity.status(HttpStatus.OK).body("Sell book(s) succeeded");
    }

//    @GetMapping("/getByPrice")
}
