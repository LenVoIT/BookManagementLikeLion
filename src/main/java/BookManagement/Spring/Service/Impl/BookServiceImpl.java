package BookManagement.Spring.Service.Impl;

import BookManagement.Spring.Entity.BookEntity;
import BookManagement.Spring.Repository.BookRepository;
import BookManagement.Spring.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public void remove(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Iterable<BookEntity> findAll() {
        return null;
    }

    @Override
    public BookEntity findById(int id) {
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    @Override
    public BookEntity sellBook(int id, int sellQuantity) {
        Optional<BookEntity> bookInDb = bookRepository.findById(id);
        BookEntity bookSold = null;
        if(bookInDb.isPresent()){
            bookSold = bookInDb.get();
            bookSold.setName(bookSold.getName());
            bookSold.setQuantity(bookSold.getQuantity() - sellQuantity);
        }
        return bookRepository.save(bookSold);
    }

    @Override
    public Iterable<BookEntity> findAllByOrderByPriceAsc() {
        return bookRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public Iterable<BookEntity> findAllByOrderBySoldQuantityDesc() {
        return bookRepository.findAllByOrderBySoldQuantityDesc();
    }
}
