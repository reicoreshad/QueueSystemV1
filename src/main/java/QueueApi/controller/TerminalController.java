package QueueApi.controller;

import QueueApi.dto.TicketTypeDto;
import QueueApi.dto.request.NewTicketRequest;
import QueueApi.dto.response.AllTicketTypeResponse;
import QueueApi.dto.response.NewTicketResponse;
import QueueApi.service.QueTicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/terminal")
public class TerminalController {
    private final QueTicketService queTicketService;

    public TerminalController(QueTicketService queTicketService) {
        this.queTicketService = queTicketService;
    }

    @GetMapping("/getAllTickets")
    public List<AllTicketTypeResponse> getTicketTypes(){
        return queTicketService.getTicketTypes();
    }

    @PostMapping ("/newTicket")
    public NewTicketResponse getTicket (@RequestBody NewTicketRequest newTicketRequest){

        NewTicketResponse newTicketResponse = queTicketService.getNewTicket(newTicketRequest);
        //System.out.println(newTicketResponse.toString());
       return newTicketResponse;
    }
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        queTicketService.deleteTicket(id);
    }
}
