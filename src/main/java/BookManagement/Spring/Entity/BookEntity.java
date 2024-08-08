package BookManagement.Spring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Entity
@Table(name = "tbl_book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity extends BaseEntity{
    @Column
    private String name;
    @Column
    private int status;
    @Column
    private int quantity;
    @Column
    private int soldQuantity;
    @Column
    private BigDecimal price;
    @Column
    private Date releaseDate;
    @Column
    private String description;
    @ManyToMany(mappedBy = "bookEntities", fetch = FetchType.LAZY)
    private Collection<UserEntity> userEntities;
}
