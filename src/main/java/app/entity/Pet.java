package app.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.EnumType.*;

@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long id;
    @OneToOne(mappedBy = "pet",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Category category;

    private String photoUrls;
    @OneToOne(mappedBy = "pet",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Tag tag;
    @Enumerated(STRING)
    private Status status;

    public enum Status {
        AVAILABLE,
        PENDING,
        SOLD
    }
}
