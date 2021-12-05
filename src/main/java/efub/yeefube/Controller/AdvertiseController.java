package efub.yeefube.Controller;

import efub.yeefube.Controller.dto.AdvertiseResponseDto;
import efub.yeefube.Repository.AdvertiseRepository;
import efub.yeefube.Service.AdvertiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    @GetMapping("/advertise")
    public AdvertiseResponseDto getAdvertiseRandom() {
        return advertiseService.findInfoRandom();
    }

    @GetMapping("/advertise/{id}")
    public AdvertiseResponseDto getAdvertise(@PathVariable Long id) {
        return advertiseService.findInfo(id);
    }

    @GetMapping("/user/{uid}/advertise/{id}/cost")
    public Double getCost(@PathVariable Long uid, @PathVariable Long id) {
        int count = advertiseService.addCount(id);
        return advertiseService.findCost(uid, id);
    }


}
