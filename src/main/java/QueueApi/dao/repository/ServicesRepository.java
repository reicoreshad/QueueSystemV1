package QueueApi.dao.repository;

import QueueApi.dao.entity.Services;
import QueueApi.dao.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    Services findByIdAndDataStatus(Long Id, Short dataStatus);
}
