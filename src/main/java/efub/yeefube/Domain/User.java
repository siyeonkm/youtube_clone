package efub.yeefube.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column
    private String userId;

    @Column
    private String userPassword;

    @Column
    private LocalDateTime userCreatedAt;

    @Builder
    public User(String id, String pw) {
        this.userId = id;
        this.userPassword = pw;
        LocalDateTime now = LocalDateTime.now();
        this.userCreatedAt = now;
    }

}
