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
@Table(name="video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoIdx;

    @Column
    private String videoUrl;

    @Column
    private String videoThumbnail;

    @Column
    private LocalDateTime videoCreatedAt;

    @Column
    private String videoTitle;

    @Column
    private String videoDetail;

    @Column
    private String videoCategory;

    @ManyToOne
    @JoinColumn(name="category")
    private Category category;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    @Column
    private Integer videoCount;

    @Column
    private String videoChannel;

    @Builder
    public Video(String url, String thumb, String title, String detail, Category category, User user) {
        this.videoUrl = url;
        this.videoThumbnail = thumb;
        this.videoTitle = title;
        this.videoDetail = detail;
        this.category = category;
        this.user = user;
        this.videoCount = 0;
        this.videoChannel = "문명특급";

        LocalDateTime now = LocalDateTime.now();
        this.videoCreatedAt = now;
    }

    public void updateCnt() {
        this.videoCount += 1;
    }

}
