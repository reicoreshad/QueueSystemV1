package QueueApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewTicketResponse {
    private String ticketNo;
    private String ticketTypeName;
    private LocalDateTime dateTime;
    private String structureName;
    private Long queOrder;
    private Long userTicketId;
}
