package QueueApi.dao.repository;

import QueueApi.dao.entity.*;
import QueueApi.dto.ClientTicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface QueTicketRepository extends JpaRepository<QueTicket, Long> {
    QueTicket findTop1ByStructureIdAndServiceIdAndTicketTypeIdAndStatusIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc
            (Long structureId, Long serviceId, Long ticketTypeId, Long statusId, Short dataStatus,
             LocalDateTime dateTime);

    QueTicket findTop1ByStructureIdAndServiceIdAndTicketTypeIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc
            (Long structureId, Long serviceId, Long ticketTypeId, Short dataStatus,
             LocalDateTime dateTime);

    Boolean existsByStructureIdAndServiceIdAndTicketTypeIdAndStatusIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc
            (Long structureId, Long serviceId, Long ticketTypeId, Long statusId, Short dataStatus,
             LocalDateTime dateTime);

    Boolean existsByStructureIdAndServiceIdAndTicketTypeIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc
            (Long structureId, Long serviceId, Long ticketTypeId, Short dataStatus,
             LocalDateTime dateTime);

    long countByStructureIdAndServiceIdAndTicketTypeIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc
            (Long structureId, Long serviceId, Long ticketTypeId, Short dataStatus,
             LocalDateTime dateTime);

    QueTicket findByIdAndDataStatus(Long Id, Short dataStatus);

    @Query(value = "SELECT qt.id as queTicketId,ut.id as userTicketId, qt.number,tt.label, qt.type_id as ticketTypeId FROM que_schema.user_tickets ut left join que_schema.que_ticket as qt on ut.ticket_id=qt.id\n" +
                    "left join que_schema.ticket_type as tt on qt.type_id=tt.id\n" +
                    "\t\tWHERE ut.user_id=:userId and ut.service_unit_id=:serviceUnitId and ut.status_id=2 and ut.data_status=1 and\n" +
                    "\t\tut.receive_date<LOCALTIMESTAMP and (CAST(ut.receive_date as date)=CURRENT_DATE OR \n" +
                    "\t\t\t(DATE_PART('day', ut.receive_date - LOCALTIMESTAMP) * 24 + \n" +
                    "\t\t\tDATE_PART('hour', ut.receive_date - LOCALTIMESTAMP) * 60 +\n" +
                    "\t\t\t\tDATE_PART('minute', ut.receive_date - LOCALTIMESTAMP))<3*60)\n" +
                    "\t\torder by ut.id desc limit 1",
            nativeQuery = true)
//    @Nullable
    ClientTicketDto findUsersActiveTicket(Long userId, Long serviceUnitId);

    @Query(
            value = "SELECT count(*) FROM que_schema.user_tickets ut left join que_schema.que_ticket as qt on ut.ticket_id=qt.id\n" +
                    "\t\tleft join que_schema.ticket_type as tt on qt.type_id=tt.id\n" +
                    "\t\tWHERE ut.user_id=:userId and ut.service_unit_id=:serviceUnitId and ut.status_id=2 and ut.data_status=1 and\n" +
                    "\t\tut.receive_date<LOCALTIMESTAMP and (CAST(ut.receive_date as date)=CURRENT_DATE OR \n" +
                    "\t\t\t(DATE_PART('day', ut.receive_date - LOCALTIMESTAMP) * 24 + \n" +
                    "\t\t\tDATE_PART('hour', ut.receive_date - LOCALTIMESTAMP) * 60 +\n" +
                    "\t\t\t\tDATE_PART('minute', ut.receive_date - LOCALTIMESTAMP))<3*60)\n",
            nativeQuery = true)
    Integer existUserActiveTicket(Long userId, Long serviceUnitId);


    QueTicket findTop1ByStructureIdAndTicketTypeIdInAndDataStatusAndDateTimeAfterAndStatusIdOrderByDateTimeAsc
            (Long structureId, List<Long> ticketTypeId, Short dataStatus,
             LocalDateTime dateTime, Long statusId);


}
