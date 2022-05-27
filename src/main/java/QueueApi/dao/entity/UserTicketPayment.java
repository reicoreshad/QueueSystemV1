package QueueApi.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user_ticket_payment",schema = "que_schema")
public class UserTicketPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_ticket_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = UserTickets.class)
    @JoinColumn(name="user_ticket_id",referencedColumnName = "id")
    private UserTickets userTickets;

   // @Column(name = "treasurer_user_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Users.class)
    @JoinColumn(name="treasurer_user_id",referencedColumnName = "id")
    private Users users;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;

    @Column(name = "giveback_amount")
    private BigDecimal givebackAmount;

    private Short status;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
