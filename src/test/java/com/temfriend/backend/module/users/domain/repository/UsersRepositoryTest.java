package com.temfriend.backend.module.users.domain.repository;

import com.temfriend.backend.module.users.domain.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Repository : UsersRepository")
@DataJpaTest
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    private static final String EMAIL = "tester@test.com";
    private static final String NON_EXISTENT_EMAIL = "anotherTester@test.com";
    private static final String PASSWORD = "password123";
    private static final String NAME = "홍길동";
    private static final String NICKNAME = "tester";
    private static final String NON_EXISTENT_NICKNAME = "anotherTester";
    private static final String IMG = "test.png";

    @BeforeEach
    void saveUsersToRepository() {
        this.usersRepository.deleteAll();
        Users users = generateUsers();
        this.usersRepository.save(users);
    }

    @DisplayName("Success : 존재하는 이메일로 유저 로드에 성공할 것이다.")
    @Test
    void success_findByValidEmailTest() {
        Optional<Users> foundUsers = usersRepository.findByEmail(EMAIL);

        assertThat(foundUsers.isPresent())
                .isTrue();

        assertThat(foundUsers.get().getEmail())
                .isEqualTo(EMAIL);

        assertThat(foundUsers.get().getName())
                .isEqualTo(NAME);

        assertThat(foundUsers.get().getNickname())
                .isEqualTo(NICKNAME);
    }

    @DisplayName("Exception : 존재하지 않는 이메일로 유저 로드 시 익셉션이 발생할 것이다.")
    @Test
    void exception_thrownForFindByInvalidEmailTest() {
        Optional<Users> foundUsers = usersRepository.findByEmail(NON_EXISTENT_EMAIL);

        assertThat(foundUsers.isPresent())
                .isFalse();

        assertThatThrownBy(foundUsers::get)
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("Success : 존재하는 이메일로 유저 조회 결과는 True일 것이다.")
    @Test
    void success_existsByValidEmailTest() {
        boolean existsByEmail = usersRepository.existsByEmail(EMAIL);

        assertThat(existsByEmail)
                .isTrue();
    }

    @DisplayName("Success : 존재하지 않는 이메일로 유저 조회 결과는 False일 것이다.")
    @Test
    void success_existsByInvalidEmailTest() {
        boolean existsByEmail = usersRepository.existsByEmail(NON_EXISTENT_EMAIL);

        assertThat(existsByEmail)
                .isFalse();
    }

    @DisplayName("Success : 존재하는 닉네임으로 유저를 조회한 결과는 True일 것이다.")
    @Test
    void success_existsByValidNicknameTest() {
        boolean existsByProfileNickname = usersRepository.existsByProfile_Nickname(NICKNAME);

        assertThat(existsByProfileNickname)
                .isTrue();
    }

    @DisplayName("Success : 존재하지 않는 닉네임으로 유저를 조회한 결과는 False일 것이다.")
    @Test
    void success_existsByInvalidNicknameTest() {
        boolean existsByProfileNickname = usersRepository.existsByProfile_Nickname(NON_EXISTENT_NICKNAME);

        assertThat(existsByProfileNickname)
                .isFalse();
    }

    private static Users generateUsers() {
        return Users.builder()
                .email(EMAIL)
                .password(PASSWORD)
                .name(NAME)
                .nickname(NICKNAME)
                .img(IMG)
                .build();
    }
}