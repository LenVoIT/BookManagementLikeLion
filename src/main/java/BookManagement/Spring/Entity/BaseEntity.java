package BookManagement.Spring.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date createAt;

    @Column
    private Date updateAt;
}
