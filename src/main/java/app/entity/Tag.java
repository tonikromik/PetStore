package app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Pet pet;
}
