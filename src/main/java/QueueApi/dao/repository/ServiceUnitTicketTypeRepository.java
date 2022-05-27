package QueueApi.dao.repository;

import QueueApi.dao.entity.ServiceUnitTicketType;
import QueueApi.dao.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceUnitTicketTypeRepository extends JpaRepository<ServiceUnitTicketType, Long> {
    ServiceUnitTicketType findByIdAndDataStatus(Long Id, Short dataStatus);
    List<ServiceUnitTicketType> findByServiceUnitIdAndDataStatus(Long serviceUnitId, Short dataStatus);
}
