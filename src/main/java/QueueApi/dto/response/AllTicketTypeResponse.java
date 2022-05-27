package QueueApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllTicketTypeResponse {
    private String name;
    private String label;
    private String nameRu;
    private String nameEn;
}
