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
    private String name;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private String photoUrls;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;
    @Enumerated(STRING)
    private Status status;

    public enum Status {
        AVAILABLE,
        PENDING,
        SOLD
    }
}
