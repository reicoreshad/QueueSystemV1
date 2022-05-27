package QueueApi.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="ticket_type",schema = "que_schema",uniqueConstraints = {
        @UniqueConstraint(columnNames = "label")
})
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 10)
    private String label;

    @Column(name = "name_ru", length = 100)
    private String nameRu;

    @Column(name = "name_en",length = 100)
    private String nameEn;

    @Column(name = "ticket_priority")
    private Short ticketPriority;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
