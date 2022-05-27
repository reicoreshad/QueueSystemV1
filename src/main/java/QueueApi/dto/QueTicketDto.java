package QueueApi.dto;

import QueueApi.dao.entity.Services;
import QueueApi.dao.entity.Status;
import QueueApi.dao.entity.Structure;
import QueueApi.dao.entity.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueTicketDto {
    private LocalDateTime dateTime;
    private Integer number;
    private Services service;
    private Status status;
    private Structure structure;
    private TicketType ticketType;
    private  Long queCount;
    private Short dataStatus;
}
