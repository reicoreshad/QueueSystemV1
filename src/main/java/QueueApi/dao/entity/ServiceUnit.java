package QueueApi.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="service_unit" ,schema = "que_schema",uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "monitor_ip"),
        @UniqueConstraint(columnNames = "sys_ip")
})
public class ServiceUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(name= "monitor_ip", length = 15)
    private String monitorIp;

    //@Column(name = "structure_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Structure.class)
    @JoinColumn(name="structure_id", referencedColumnName = "id")
    private Structure structure;

    @Column(name= "sys_ip", length = 15)
    private String sysIp;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
