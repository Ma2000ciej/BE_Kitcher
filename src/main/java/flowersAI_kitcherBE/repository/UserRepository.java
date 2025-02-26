package flowersAI_kitcherBE.repository;

import flowersAI_kitcherBE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // A tu mozna proste metody wrzucać jako podstawe do działania
    Optional<User> findByEmail(String email);
    ///Wszystko co poniżej to przykład jak tworzyć zapytanie tutaj SQL
    /*@Query(value = "SELECT * FROM users WHERE name = :name AND email = :email", nativeQuery = true)
    List<User> findUsersByNameAndEmailNative(@Param("name") String name, @Param("email") String email);*/
}