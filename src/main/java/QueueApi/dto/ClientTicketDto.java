package QueueApi.dto;

import QueueApi.dao.entity.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientTicketDto {
    private Long queTicketId;
    private Long userTicketId;
    private Integer number;
    private String label;
    private Long ticketTypeId;
}
