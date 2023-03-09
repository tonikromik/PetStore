package app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ApiResponce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    private String type;
    private String message;

}
