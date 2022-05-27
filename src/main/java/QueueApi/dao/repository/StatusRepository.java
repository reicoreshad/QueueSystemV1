package QueueApi.dao.repository;

import QueueApi.dao.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByIdAndDataStatus(Long Id, Short dataStatus);
    Status findByIdAndDataStatusAndQueStatus(Long Id, Short dataStatus, Short queStatus);
    Status findTop1ByDataStatusAndQueStatus(Short dataStatus, Short queStatus);
}
