package QueueApi.dao.repository;

import QueueApi.dao.entity.Services;
import QueueApi.dao.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    UserType findByIdAndDataStatus(Long Id, Short dataStatus);
}
