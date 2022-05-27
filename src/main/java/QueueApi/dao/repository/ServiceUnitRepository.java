package QueueApi.dao.repository;

import QueueApi.dao.entity.ServiceUnit;
import QueueApi.dao.entity.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceUnitRepository extends JpaRepository<ServiceUnit, Long> {
    ServiceUnit findByIdAndDataStatus(Long Id, Short dataStatus);
    ServiceUnit findBySysIpAndDataStatusAndStructure
            (String sysIp, Short dataStatus, Structure structure);
}
