package app.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.EnumType.*;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;
    private int quantity;
//    @DateTimeFormat
    private String shipDate;
    @Enumerated(STRING)
    private Status status;
    private boolean completed;

    public enum Status {
        PLACED,
        APPROVED,
        DELIVERED
    }
}
