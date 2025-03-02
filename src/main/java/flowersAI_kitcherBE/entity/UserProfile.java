package flowersAI_kitcherBE.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 1000)
    private String bio;

    @Column(name = "profile_picture", columnDefinition = "TEXT")
    private String profilePicture;

    @Column(length = 255)
    private String location;

    @Column(name = "social_media_links", columnDefinition = "jsonb")
    private String socialMediaLinks;
}