package flowersAI_kitcherBE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dietary_category")
public class DietaryCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String name;

    @Column(length = 500)
    private String description;
}