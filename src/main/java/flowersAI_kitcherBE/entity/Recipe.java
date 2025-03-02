package flowersAI_kitcherBE.entity;

import flowersAI_kitcherBE.dto.RecipeDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "jsonb")
    private String ingredients;

    @Column(nullable = false, columnDefinition = "jsonb")
    private String instructions;

    @Column(columnDefinition = "jsonb")
    private String tabs;

    @Column
    private Integer calories;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    private User createdBy;

    public Recipe (RecipeDTO recipeDTO){
        this.name=recipeDTO.getName();
        this.createdBy=new User();//recipeDTO.getAuthorId();
        //this.ingredients=recipeDTO.getIngredientList();
        this.description= recipeDTO.getDescription();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
