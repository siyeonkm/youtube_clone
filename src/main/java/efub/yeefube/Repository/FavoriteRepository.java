package efub.yeefube.Repository;

import efub.yeefube.Domain.Favorite;
import efub.yeefube.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findFavoritesByUser(User user);
    List<Favorite> findFavoritesByUserOrderByCategoryAsc(User user);
}
