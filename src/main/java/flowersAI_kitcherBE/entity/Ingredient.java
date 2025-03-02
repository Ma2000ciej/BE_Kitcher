package flowersAI_kitcherBE.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 50)
    private String unit;

    @Column(name = "calories_per_unit")
    private Float caloriesPerUnit;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private DietaryCategory category;

    @Column(unique = true, length = 255)
    private String barcode;

    @Column(name = "is_allergen")
    private Boolean isAllergen;
}