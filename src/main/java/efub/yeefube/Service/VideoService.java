package efub.yeefube.Service;

import efub.yeefube.Controller.dto.FavoriteResponseDto;
import efub.yeefube.Domain.*;
import efub.yeefube.Repository.FavoriteRepository;
import efub.yeefube.Repository.UserRepository;
import efub.yeefube.Repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class VideoService {
    private VideoRepository videoRepository;
    private UserService userService;

    @Transactional
    public Integer addCount(Long id) {
        Video entity = videoRepository.findByVideoIdx(id);
        if(entity==null) {
            System.out.println("없는 동영상입니다: video_idx = "+id);
        }
        entity.updateCnt();
        return entity.getVideoCount();
    }

    List<Video> findByVideo_category(String category){

        return videoRepository.findAllByVideoCategory(category);
    }

    public List<Video> recommendAlgorithm(Long user_num) {
        int i=0, num=0;
        boolean random = true;
        List<Video> recommend = new ArrayList<>();
        List<Integer> recommended = new ArrayList<>();
        List<Video> temp = new ArrayList<>();
        List<Category> cat = new ArrayList<>();
        List<FavoriteResponseDto> favorites;
        favorites = userService.findFavoritesByUserOrderByCategory(user_num);
        int max = 8/favorites.size();

        System.out.println(favorites.get(0).getCategoryIdx());

        for(i=0; i<favorites.size(); i++) {
            temp.addAll(videoRepository.findAllByCategory(favorites.get(i).getCategory()));
        }

        for(int j = 0; j<8; j++) {
            Random rand = new Random();
            while(random) {
                num = rand.nextInt(temp.size());
                if(!recommended.contains(num)) {
                    recommended.add(num);
                    random = false;
                }
            }
            recommend.add(temp.get(num));
            random=true;
        }
        temp.clear();
        recommended.clear();

        for(i=0; i< favorites.size(); i++) {
            cat.add(favorites.get(i).getCategory());
        }

        temp = videoRepository.findVideosByCategoryIsNotIn(cat);

        for(i=recommend.size(); i<10; i++) {
            Random rand = new Random();
            while(random) {
                num = rand.nextInt(temp.size());
                if(!recommended.contains(num)) {
                    recommended.add(num);
                    random = false;
                }
            }
            recommend.add(temp.get(num));
            random = true;
        }

        return recommend;

    }
}
