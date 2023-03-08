package app.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.EnumType.*;

@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Category category;

    private String photoUrls;
    @OneToOne
    private Tag tag;
    @Enumerated(STRING)
    private Status status;

    public enum Status {
        AVAILABLE,
        PENDING,
        SOLD
    }
}
