package efub.yeefube.Service;

import efub.yeefube.Controller.dto.AdvertiseResponseDto;
import efub.yeefube.Controller.dto.FavoriteResponseDto;
import efub.yeefube.Domain.Advertise;
import efub.yeefube.Repository.AdvertiseRepository;
import efub.yeefube.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class AdvertiseService {
    private final AdvertiseRepository advertiseRepository;
    private final UserService userService;

    @Transactional
    public AdvertiseResponseDto findInfoRandom() {
        Random rand = new Random();
        long num = (long)(rand.nextInt(4)+1);
        Advertise entity = advertiseRepository.findAdvertiseByAdvertiseIdx(num);
        return new AdvertiseResponseDto(entity);
    }

    @Transactional
    public AdvertiseResponseDto findInfo(Long id) {
        Advertise entity = advertiseRepository.findAdvertiseByAdvertiseIdx(id);
        if(entity==null) {
            System.out.println("없는 광고입니다: ad_num = "+id);
        }
        return new AdvertiseResponseDto(entity);
    }

    @Transactional
    public Double findCost(Long uid, Long id) {
        Advertise entity = advertiseRepository.findAdvertiseByAdvertiseIdx(id);
        AdvertiseResponseDto adDto = new AdvertiseResponseDto(entity);
        double base = adDto.getCategory().getCategoryDetail();
        int count = adDto.getCount();
        int mult = AdvertiseCostFunc(uid, id);

        System.out.println(count+"*"+base+"*"+mult);
        return count*(base*mult);
    }

    @Transactional
    public Integer addCount(Long id) {
        Advertise entity = advertiseRepository.findAdvertiseByAdvertiseIdx(id);
        if(entity==null) {
            System.out.println("없는 광고입니다: ad_num = "+id);
        }
        entity.updateCnt();
        return entity.getAdvertiseCount();
    }

    public Integer AdvertiseCostFunc(Long uid, Long id) {
        boolean match = false;
        Advertise entity = advertiseRepository.findAdvertiseByAdvertiseIdx(id);
        if(entity==null) {
            System.out.println("없는 광고입니다: ad_num = "+id);
        }
        AdvertiseResponseDto adDto = new AdvertiseResponseDto(entity);

        List<FavoriteResponseDto> favorites = new ArrayList<>();
        favorites = userService.findFavoritesByUser(uid);

        for( FavoriteResponseDto favorite : favorites) {
            if (favorite.getCategoryIdx() == adDto.getCategory().getCategoryIdx()) match = true;
        }
        if(match == true) return  4;
        else return 1;
    }

}
