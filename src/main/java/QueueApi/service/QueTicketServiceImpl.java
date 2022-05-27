package QueueApi.service;

import QueueApi.dao.entity.*;
import QueueApi.dao.repository.*;
import QueueApi.dto.*;
import QueueApi.dto.request.NewTicketRequest;
import QueueApi.dto.response.AllTicketTypeResponse;
import QueueApi.dto.response.NewTicketResponse;
import QueueApi.util.GetQueNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class QueTicketServiceImpl implements QueTicketService {

    @Autowired
    QueTicketRepository queTicketRepository;
    @Autowired
    TicketTypeRepository ticketTypeRepository;
    @Autowired
    StructureRepository structureRepository;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    GetQueNumber getQueNumber;


    @Override
    public List<AllTicketTypeResponse> getTicketTypes() {
        List<TicketType> ticketType = ticketTypeRepository.findByDataStatusOrderByTicketPriorityAsc((short) 1);
        return ticketType.stream().map(ticketTypeEntity -> AllTicketTypeResponse.builder()
                .name(ticketTypeEntity.getName())
                .nameEn(ticketTypeEntity.getNameEn())
                .nameRu(ticketTypeEntity.getNameRu())
                .label(ticketTypeEntity.getLabel())
                .build()).collect(Collectors.toList());
    }


    @Override
    public QueTicketDto getQueTicket(NewTicketRequest newTicketRequest) {
        LocalDateTime now = LocalDateTime.now().with(LocalTime.MIDNIGHT);
        long queCount = queTicketRepository.countByStructureIdAndServiceIdAndTicketTypeIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc(newTicketRequest.getStructureId(), newTicketRequest.getServiceId(), newTicketRequest.getTicketTypeId(), (short) 1, now);
        if (queCount > 0) {
            QueTicket queTickets = queTicketRepository.findTop1ByStructureIdAndServiceIdAndTicketTypeIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc
                    (newTicketRequest.getStructureId(), newTicketRequest.getServiceId(), newTicketRequest.getTicketTypeId(),
                            (short) 1, now);

            return QueTicketDto.builder()
                    .dateTime(queTickets.getDateTime())
                    .number(queTickets.getNumber())
                    .service(queTickets.getService())
                    .status(queTickets.getStatus())
                    .structure(queTickets.getStructure())
                    .ticketType(queTickets.getTicketType())
                    .queCount(queCount)
                    .dataStatus(queTickets.getDataStatus())
                    .build();
        } else {

            return
                    QueTicketDto.builder()
                            .dateTime(LocalDateTime.now())
                            .number(0)
                            .service(servicesRepository.findByIdAndDataStatus(newTicketRequest.getServiceId(), (short) 1))
                            .status(statusRepository.findByIdAndDataStatus(newTicketRequest.getStatusId(), (short) 1))
                            .structure(structureRepository.findByIdAndDataStatus(newTicketRequest.getStructureId(), (short) 1))
                            .ticketType(ticketTypeRepository.findByIdAndDataStatus(newTicketRequest.getTicketTypeId(), (short) 1))
                            .queCount(queCount)
                            .dataStatus((short) 1)
                            .build();
        }
    }

    @Override
    public void addNewTicket(QueTicketDto queTicketDto) {

        QueTicket queTicket = new QueTicket();
        queTicket.setDateTime(queTicketDto.getDateTime());
        queTicket.setNumber(queTicketDto.getNumber() + 1);
        queTicket.setService(queTicketDto.getService());
        queTicket.setStatus(queTicketDto.getStatus());
        queTicket.setStructure(queTicketDto.getStructure());
        queTicket.setTicketType(queTicketDto.getTicketType());
        queTicketRepository.save(queTicket);
    }

    @Override
    public void deleteTicket(Long Id) {
        QueTicket existQueTicket = queTicketRepository.findById(Id).orElseThrow(() -> new RuntimeException("Id not found"));
        existQueTicket.setDataStatus((short) 0);
        queTicketRepository.save(existQueTicket);
    }

    @Override
    public NewTicketResponse getNewTicket(NewTicketRequest newTicketRequest) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        QueTicketDto lastTicket = getQueTicket(newTicketRequest);
        Integer newTicketNumber = lastTicket.getNumber() + 1;
        String newNumber = getQueNumber.getQueNumber(lastTicket.getTicketType().getLabel(), newTicketNumber.toString());
        QueTicket newQueTicket = new QueTicket();
        newQueTicket.setTicketType(lastTicket.getTicketType());
        newQueTicket.setService(lastTicket.getService());
        newQueTicket.setStructure(lastTicket.getStructure());
        newQueTicket.setDateTime(nowDateTime);
        newQueTicket.setNumber(newTicketNumber);
        newQueTicket.setDataStatus((short) 1);
        newQueTicket.setStatus(statusRepository.findByIdAndDataStatus((long) 1, (short) 1));
        queTicketRepository.save(newQueTicket);

        return NewTicketResponse.builder()
                .ticketNo(newNumber)
                .ticketTypeName(lastTicket.getTicketType().getName())
                .structureName(lastTicket.getStructure().getName())
                .queOrder(lastTicket.getQueCount())
                .dateTime(nowDateTime)
                .build();
    }

}
