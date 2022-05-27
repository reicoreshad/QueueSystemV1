package QueueApi.service;

import QueueApi.dao.entity.Services;
import QueueApi.dao.entity.Status;
import QueueApi.dao.entity.Structure;
import QueueApi.dao.entity.TicketType;
import QueueApi.dto.*;
import QueueApi.dto.request.NewTicketRequest;
import QueueApi.dto.response.AllTicketTypeResponse;
import QueueApi.dto.response.NewTicketResponse;


import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.List;

public interface QueTicketService {
    QueTicketDto getQueTicket(NewTicketRequest newTicketRequest);
    void addNewTicket (QueTicketDto queTicketDto);

    void deleteTicket (Long Id);

    NewTicketResponse getNewTicket(NewTicketRequest newTicketRequest);

    List<AllTicketTypeResponse> getTicketTypes ();

}
