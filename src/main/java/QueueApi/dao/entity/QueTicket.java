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
@Table(name ="que_ticket",schema = "que_schema")
public class QueTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name ="date_time")
    private LocalDateTime dateTime;

    private Integer number;

   // @Column(name = "service_id")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Services.class)
    @JoinColumn(name="service_id", referencedColumnName = "id")
    private Services service;

   // @Column(name = "status_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Status.class)
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;

    //@Column(name = "structure_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Structure.class)
    @JoinColumn(name="structure_id", referencedColumnName = "id")
    private Structure structure;

    //@Column(name = "type_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = TicketType.class)
    @JoinColumn(name="type_id", referencedColumnName = "id")
    private TicketType ticketType;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;

}
