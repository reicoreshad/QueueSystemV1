package QueueApi.dao.repository;

import QueueApi.dao.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    TicketType findByIdAndDataStatus(Long Id, Short dataStatus);
    List<TicketType> findByDataStatusOrderByTicketPriorityAsc(Short dataStatus);
}
