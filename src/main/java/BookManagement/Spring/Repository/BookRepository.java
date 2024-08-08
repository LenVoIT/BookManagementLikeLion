package BookManagement.Spring.Repository;

import BookManagement.Spring.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    Iterable<BookEntity> findAllByOrderByPriceAsc();
    Iterable<BookEntity> findAllByOrderBySoldQuantityDesc();
}
