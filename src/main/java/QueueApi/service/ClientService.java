package QueueApi.service;
import QueueApi.dto.ClientTicketDto;
import QueueApi.dto.request.ClientTicketRequest;
import QueueApi.dto.response.NewTicketResponse;


public interface ClientService {
    ClientTicketDto getActiveTicket(ClientTicketRequest clientTicketRequest);
    NewTicketResponse getClientTicket(ClientTicketRequest clientTicketRequest);
    boolean existActiveTicket(ClientTicketRequest clientTicketRequest);

}
