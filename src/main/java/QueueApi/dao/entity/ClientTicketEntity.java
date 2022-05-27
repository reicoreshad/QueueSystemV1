package QueueApi.dao.entity;

import QueueApi.dto.ClientTicketDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedNativeQuery(name = "ClientTicketEntity.ClientTicket_Named",
        query = "SELECT  qt.id  queTicketId,0  userTicketId,  COALESCE(qt.number,0)  number,tt.label,  qt.type_id  ticketTypeId " +
                "FROM que_schema.que_ticket as qt \n" +
                "LEFT JOIN que_schema.ticket_type tt on qt.type_id=tt.id\n" +
                "WHERE  qt.data_status=1 and qt.structure_id=(Select structure_id from que_schema.users where id = :userId) \n" +
                "\t\t\tand CAST(qt.date_time AS DATE)=CURRENT_DATE \n" +
                "\t\t\tand qt.status_id in (SELECT id FROM que_schema.status WHERE que_status=1 and data_status=1)  \n" +
                "\t\t\tand qt.type_id in (SELECT ticket_type_id \n" +
                "\t\t\t\t\t\t\t   FROM que_schema.service_unit_ticket_type \n" +
                "\t\t\t\t\t\t\t   WHERE service_unit_id=:serviceUnitId and data_status=1)\n" +
                "ORDER BY tt.ticket_priority ASC,qt.date_time ASC limit 1",
        resultSetMapping = "Mapping.ClientTicketDto")





@SqlResultSetMapping(
        name = "Mapping.ClientTicketDto",
        classes = @ConstructorResult(
                targetClass = ClientTicketDto.class,
                columns = {
                        @ColumnResult(name = "queTicketId", type = Long.class),
                        @ColumnResult(name = "userTicketId", type = Long.class),
                        @ColumnResult(name = "number", type = Integer.class),
                        @ColumnResult(name = "label", type = Integer.class),
                        @ColumnResult(name = "ticketTypeId", type = Long.class)
                }
        )
)

public class ClientTicketEntity {

}
