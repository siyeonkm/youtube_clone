package efub.yeefube.Controller;

import efub.yeefube.Controller.dto.FavoriteResponseDto;
import efub.yeefube.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}/favorite")
    public List<FavoriteResponseDto> findFavorite(@PathVariable Long id) {
        return userService.findFavoritesByUser(id);
    }
}
