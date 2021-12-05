package efub.yeefube.Controller;

import efub.yeefube.Domain.Video;
import efub.yeefube.Repository.VideoRepository;
import efub.yeefube.Service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VideoController {

    private final VideoRepository videoRepository;
    private final VideoService videoService;

    //전체 게시글 목록 리턴
    @GetMapping("/video/list")
    public List<Video> getAllVideo(){
        return videoRepository.findAll();
    }

    //카테고리별 게시글 목록 리턴
    @GetMapping("/video/list/{category}")
    public List<Video> getAllPostByCategory(@PathVariable("category") String category){
        return videoRepository.findAllByVideoCategory(category);
    }

    // 개별 동영상 정보
    @GetMapping("/video/get/{id}")
    public Video getVideoInfo(@PathVariable("id")Long id){
        return videoRepository.findByVideoIdx(id);
    }

    @GetMapping("/video/get/{id}/count")
    public Integer addVideoCount(@PathVariable Long id) {
        return videoService.addCount(id);
    }

    // 동영상 제목이 {title} 포함하는 모든 동영상 리턴
    @GetMapping("/video/{title}")
    public List<Video> getVideoInfo(@PathVariable("title")String title){
        return videoRepository.findAllByVideoTitleContaining(title);
    }

    @GetMapping("user/{uid}/video/list/recommend")
    public List<Video> getVideoRecommend(@PathVariable Long uid) {
        return videoService.recommendAlgorithm(uid);
    }



}
