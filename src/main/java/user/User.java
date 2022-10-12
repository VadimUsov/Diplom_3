package user;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getRandomUser() {
        return new User(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10) + "@test.ru",
                RandomStringUtils.randomAlphanumeric(10)
        );
    }

    public static User getRandomUserWithShortPassword() {
        return new User(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10) + "@test.ru",
                RandomStringUtils.randomAlphanumeric(5)
        );
    }

    public static User getRealUser() {
        return new User(
                "realuser",
                "ivanovtest@test.com",
                "1234567"
        );
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
