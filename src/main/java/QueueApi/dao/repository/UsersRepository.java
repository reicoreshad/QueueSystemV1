package QueueApi.dao.repository;

import QueueApi.dao.entity.UserType;
import QueueApi.dao.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByIdAndDataStatus(Long Id, Short dataStatus);
}
