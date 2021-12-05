package efub.yeefube.Repository;

import efub.yeefube.Domain.Advertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Long> {
    Advertise findAdvertiseByAdvertiseIdx(Long id);
}