package efub.yeefube.Controller.dto;

import efub.yeefube.Domain.Category;
import efub.yeefube.Domain.Favorite;
import efub.yeefube.Domain.User;
import lombok.Getter;

@Getter
public class FavoriteResponseDto {
    private Long favoriteIdx;
    private Long userIdx;
    private Long categoryIdx;
    private Double categoryCost;
    private Category category;

    public FavoriteResponseDto(Favorite entity) {
        this.favoriteIdx = entity.getFavoriteIdx();
        this.userIdx = entity.getUser().getUserIdx();
        this.category = entity.getCategory();
        this.categoryIdx = entity.getCategory().getCategoryIdx();
        this.categoryCost = entity.getCategory().getCategoryDetail();
    }
}
