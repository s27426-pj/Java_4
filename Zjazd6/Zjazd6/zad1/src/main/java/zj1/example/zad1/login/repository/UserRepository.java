package zj1.example.zad1.login.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Repository;
import zj1.example.zad1.login.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    @Transactional
    default User saveIfNotExist(OAuth2User oAuth2User) {
        return findByEmail(oAuth2User.getAttribute("email")).orElseGet(() -> save(createUser(oAuth2User)));
    }

    private User createUser(OAuth2User oAuth2User) {
        return User.builder()
                .id(oAuth2User.getAttribute("id"))
                .email(oAuth2User.getAttribute("email"))
                .build();
    }


}