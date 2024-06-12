package zj1.example.zad1.login.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import zj1.example.zad1.login.CustomOAuth2User;
import zj1.example.zad1.login.repository.UserRepository;



@Service
@RequiredArgsConstructor
public class UserService extends DefaultOAuth2UserService {

    private final UserRepository repository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        repository.saveIfNotExist(oAuth2User);
        return new CustomOAuth2User(oAuth2User);
    }
}