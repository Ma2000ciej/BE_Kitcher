package flowersAI_kitcherBE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_dietary_restriction")
public class UserDietaryRestriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private DietaryCategory category;
}