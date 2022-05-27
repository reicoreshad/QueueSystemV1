package QueueApi.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users",schema = "que_schema",uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name")
})
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(name = "user_name", length = 150)
    private String userName;

    @Column(name = "user_pass", length = 150)
    private String userPassword;

   // @Column(name = "structure_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = Structure.class)
    @JoinColumn(name="structure_id",referencedColumnName = "id")
    private Structure structure;

    //@Column(name = "user_type_id")
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity = UserType.class)
    @JoinColumn(name="user_type_id",referencedColumnName = "id")
    private UserType userType;

    @Column(name = "data_status", columnDefinition="smallint default 1")
    private Short dataStatus;
}
