package QueueApi.dao.repository;

import QueueApi.dao.entity.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureRepository extends JpaRepository<Structure, Long> {
    Structure findByIdAndDataStatus(Long Id, Short dataStatus);
}
