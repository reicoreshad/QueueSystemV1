package QueueApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewTicketRequest {
    private Long structureId;
    private Long serviceId;
    private Long ticketTypeId;
    private Long statusId;
}
