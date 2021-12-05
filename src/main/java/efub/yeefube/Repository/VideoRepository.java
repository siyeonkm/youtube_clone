package efub.yeefube.Repository;


import efub.yeefube.Domain.Category;
import efub.yeefube.Domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("select p from Video p where p.videoCategory like ?1")
    List<Video> findAllByVideoCategory(String category);

    List<Video> findAllByCategory(Category category);

    @Query("select p from Video p where p.videoIdx=?1")
    Video findByVideoIdx(Long id);

    List<Video> findAllByVideoTitleContaining(String title);

    List<Video> findVideosByCategoryNot(Category category);

    List<Video> findVideosByCategoryIsNotIn(List<Category> cat);

}
