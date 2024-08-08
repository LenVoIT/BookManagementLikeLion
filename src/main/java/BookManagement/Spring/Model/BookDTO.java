package BookManagement.Spring.Model;

import BookManagement.Spring.Entity.BookEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Data
public class BookDTO extends BaseDTO {
    private String name;
    private int quantity;
    private int soldQuantity;
    private int status;
    private BigDecimal price;
    private Date releaseDate;
    private String description;
    private Collection<BookEntity> bookEntities;
}
