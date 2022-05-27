package QueueApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketTypeDto {
    private String name;
    private String label;
    private String nameRu;
    private String nameEn;
    private Short ticketPriority;
    private Short dataStatus;
}
