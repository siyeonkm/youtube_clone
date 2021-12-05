package efub.yeefube.Controller.dto;

import efub.yeefube.Domain.Advertise;
import efub.yeefube.Domain.Category;
import lombok.Getter;

@Getter
public class AdvertiseResponseDto {
    private String company;
    private String title;
    private String detail;
    private Integer count;
    private String thumbnail;
    private String url;
    private Category category;

    public AdvertiseResponseDto(Advertise entity) {
        this.company = entity.getAdvertiseCompany();
        this.title = entity.getAdvertiseTitle();
        this.detail = entity.getAdvertiseDetail();
        this.count = entity.getAdvertiseCount();
        this.thumbnail = entity.getAdvertiseThumbnail();
        this.url = entity.getAdvertiseUrl();
        this.category = entity.getCategory();
    }

}
