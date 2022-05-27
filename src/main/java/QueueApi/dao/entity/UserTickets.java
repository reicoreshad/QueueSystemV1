package QueueApi.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user_tickets",schema = "que_schema")
public class UserTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Users.class)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private Users users;

    //@Column(name = "ticket_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = QueTicket.class)
    @JoinColumn(name="ticket_id",referencedColumnName = "id")
    private QueTicket queTicket;

    //@Column(name = "service_unit_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = ServiceUnit.class)
    @JoinColumn(name="service_unit_id",referencedColumnName = "id")
    private ServiceUnit serviceUnit;

    @Column(name = "receive_date")
    private LocalDateTime receiveDate;

    //@Column(name = "status_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Status.class)
    @JoinColumn(name="status_id",referencedColumnName = "id")
    private Status status;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
