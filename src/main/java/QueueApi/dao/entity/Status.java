package QueueApi.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="status",schema = "que_schema",uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(name="que_status")
    private Short queStatus;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
