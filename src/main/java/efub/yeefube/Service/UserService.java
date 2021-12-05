package efub.yeefube.Service;

import efub.yeefube.Controller.dto.FavoriteResponseDto;
import efub.yeefube.Domain.Favorite;
import efub.yeefube.Domain.User;
import efub.yeefube.Repository.FavoriteRepository;
import efub.yeefube.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;

    public List<FavoriteResponseDto> findFavoritesByUser(Long id) {
        User entity = userRepository.findUserByUserIdx(id);

        List<FavoriteResponseDto> favorites = new ArrayList<>();
        for(Favorite favorite: favoriteRepository.findFavoritesByUser(entity)) {
            favorites.add(new FavoriteResponseDto(favorite));
        }
        return favorites;

    }

    public List<FavoriteResponseDto> findFavoritesByUserOrderByCategory(Long id) {
        User entity = userRepository.findUserByUserIdx(id);

        List<FavoriteResponseDto> favorites = new ArrayList<>();
        for(Favorite favorite: favoriteRepository.findFavoritesByUserOrderByCategoryAsc(entity)) {
            favorites.add(new FavoriteResponseDto(favorite));
        }
        return favorites;

    }

}
