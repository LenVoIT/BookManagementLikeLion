package BookManagement.Spring.Service;

import BookManagement.Spring.Entity.BookEntity;

public interface BookService extends BaseService<BookEntity> {
    BookEntity sellBook(int id, int sellQuantity);
    Iterable<BookEntity> findAllByOrderByPriceAsc();
}
