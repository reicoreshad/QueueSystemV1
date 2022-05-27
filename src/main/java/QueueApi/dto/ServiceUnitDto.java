package QueueApi.dto;

import QueueApi.dao.entity.Structure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceUnitDto {
    private String name;
    private String monitorIp;
    private StructureDto structureDto;
    private String sysIp;
    private Short dataStatus;
}
