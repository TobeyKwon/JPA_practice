package study.datajpa.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class UsernameOnlyDto {

    private final String username;

    public UsernameOnlyDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
