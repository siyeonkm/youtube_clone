package efub.yeefube.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="advertise")
public class Advertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertiseIdx;

    @Column
    private String advertiseCompany;

    @Column
    private String advertiseTitle;

    @Column
    private String advertiseDetail;

    @Column
    private Integer advertiseCount;

    @Column
    private String advertiseThumbnail;

    @Column
    private String advertiseUrl;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @Builder
    public Advertise(Category category, String name, String title, String detail, String thumb, String url) {
        this.category = category;
        this.advertiseCompany = name;
        this.advertiseTitle = title;
        this.advertiseDetail = detail;
        this.advertiseThumbnail = thumb;
        this.advertiseUrl = url;
        this.advertiseCount = 0;
    }

    public void updateCnt() {
        this.advertiseCount += 1;
    }

}
