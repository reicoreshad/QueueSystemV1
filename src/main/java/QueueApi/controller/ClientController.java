package QueueApi.controller;
import QueueApi.dto.ClientTicketDto;
import QueueApi.dto.request.ClientTicketRequest;
import QueueApi.dto.request.NewTicketRequest;
import QueueApi.dto.response.NewTicketResponse;
import QueueApi.service.ClientService;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/terminal")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/checkActiveTickets")
    public boolean existActiveTicket(@RequestBody ClientTicketRequest clientTicketRequest){
        return clientService.existActiveTicket(clientTicketRequest);
    }
    @GetMapping("/getActiveTickets")
    public ClientTicketDto getTicketTypes(@RequestBody ClientTicketRequest clientTicketRequest){
        ClientTicketDto clientTicketDto = clientService.getActiveTicket(clientTicketRequest);
        return clientTicketDto;
    }
    @GetMapping("/getClientTicket")
    public NewTicketResponse getClientTicket(@RequestBody ClientTicketRequest clientTicketRequest){
        NewTicketResponse newTicketResponse = clientService.getClientTicket(clientTicketRequest);
        return newTicketResponse;
    }
}
