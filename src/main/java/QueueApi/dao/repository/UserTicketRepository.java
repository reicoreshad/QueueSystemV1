package QueueApi.dao.repository;

import QueueApi.dao.entity.UserTickets;
import QueueApi.dao.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTickets, Long> {
    UserTickets findByIdAndDataStatus(Long Id, Short dataStatus);

}
