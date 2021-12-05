package efub.yeefube.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;

    @Column
    private String commentAuthor;

    @Column
    private String commentContent;

    @Column
    private LocalDateTime commentCreatedAt;

    @Column
    private LocalDateTime commentUpdatedAt;

    @Builder
    public Comment(String auth, String content) {
        this.commentAuthor = auth;
        this.commentContent = content;

        LocalDateTime now = LocalDateTime.now();
        this.commentCreatedAt = now;
        this.commentUpdatedAt = now;
    }

    public void updateComment(String content) {
        this.commentContent = content;

        LocalDateTime now = LocalDateTime.now();
        this.commentUpdatedAt = now;
    }

}
