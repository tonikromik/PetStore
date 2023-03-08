package app.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import static jakarta.persistence.EnumType.*;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long petId;
    private int quantity;
    @DateTimeFormat
    private String shipDate;
    @Enumerated(STRING)
    private Status status;
    private boolean complete;

    public enum Status {
        PLACED,
        APPROVED,
        DELIVERED
    }
}
