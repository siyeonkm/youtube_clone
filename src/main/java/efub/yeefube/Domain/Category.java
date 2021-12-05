package efub.yeefube.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryIdx;

    @Column
    private String categoryName;

    @Column
    private Double categoryDetail;

    @Builder
    public Category(String name, Double detail) {
        this.categoryName = name;
        this.categoryDetail = detail;
    }

}
