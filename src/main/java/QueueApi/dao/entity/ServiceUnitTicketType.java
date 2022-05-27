package QueueApi.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="service_unit_ticket_type" ,schema = "que_schema")
public class ServiceUnitTicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(name = "service_unit_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = ServiceUnit.class)
    @JoinColumn(name="service_unit_id",referencedColumnName = "id")
    private ServiceUnit serviceUnit;

    //@Column(name = "ticket_type_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = TicketType.class)
    @JoinColumn(name="ticket_type_id", referencedColumnName = "id")
    private TicketType ticketType;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
