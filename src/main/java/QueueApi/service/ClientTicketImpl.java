package QueueApi.service;

import QueueApi.dao.entity.QueTicket;
import QueueApi.dao.entity.ServiceUnitTicketType;
import QueueApi.dao.entity.UserTickets;
import QueueApi.dao.entity.Users;
import QueueApi.dao.repository.*;
import QueueApi.dto.ClientTicketDto;
import QueueApi.dto.request.ClientTicketRequest;
import QueueApi.dto.response.NewTicketResponse;
import QueueApi.util.GetQueNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientTicketImpl implements ClientService{
    @Autowired
    QueTicketRepository queTicketRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    StructureRepository structureRepository;
    @Autowired
    ServiceUnitRepository  serviceUnitRepository;
    @Autowired
    UserTicketRepository userTicketRepository;
    @Autowired
    TicketTypeRepository ticketTypeRepository;
    @Autowired
    ServiceUnitTicketTypeRepository serviceUnitTicketTypeRepository;
    @Autowired
    GetQueNumber getQueNumber;
    @Override
    public ClientTicketDto getActiveTicket(ClientTicketRequest clientTicketRequest) {
        ClientTicketDto clientTicketDto=queTicketRepository.findUsersActiveTicket(clientTicketRequest.getUserId(),clientTicketRequest.getServiceUnitId());
        return clientTicketDto;
    }

    @Override
    public boolean existActiveTicket(ClientTicketRequest clientTicketRequest) {
        return  (queTicketRepository.existUserActiveTicket(clientTicketRequest.getUserId(), clientTicketRequest.getServiceUnitId()) > 0 )?true:false;
    }
    @Override
    public NewTicketResponse getClientTicket (ClientTicketRequest clientTicketRequest){
       if(!existActiveTicket(clientTicketRequest)) {
           Users user = usersRepository.findByIdAndDataStatus(clientTicketRequest.getUserId(), (short) 1);
           Long serviceUnitId=clientTicketRequest.getServiceUnitId();
           List<ServiceUnitTicketType> serviceUnitTicketType= serviceUnitTicketTypeRepository.findByServiceUnitIdAndDataStatus(serviceUnitId, (short)1);
           List<Long> ids=new ArrayList<Long>();
           serviceUnitTicketType.stream().map(serviceUnitTicketTypeEntity ->ids.add(serviceUnitTicketTypeEntity.getTicketType().getId())).collect(Collectors.toList());

           QueTicket queTicket=queTicketRepository.findTop1ByStructureIdAndTicketTypeIdInAndDataStatusAndDateTimeAfterAndStatusIdOrderByDateTimeAsc(
                   user.getStructure().getId(),ids,(short)1, LocalDateTime.now().with(LocalTime.MIDNIGHT),1L);





           ClientTicketDto clientTicketDto = ClientTicketDto.builder()
                   .label(queTicket.getTicketType().getLabel())
                   .number(queTicket.getNumber())
                   .queTicketId(queTicket.getId())
                   .ticketTypeId(queTicket.getTicketType().getId())
                   .userTicketId(null)
                   .build();

           queTicket.setStatus(statusRepository.findByIdAndDataStatus((long)2, (short) 1));
           queTicketRepository.save(queTicket);
           //queTicketRepository.updateQueTicketStatus( 2L,clientTicketDto.getQueTicketId());
           UserTickets userTickets = new UserTickets();
           userTickets.setQueTicket(queTicketRepository.findByIdAndDataStatus(clientTicketDto.getQueTicketId(), (short) 1));
           userTickets.setStatus(statusRepository.findByIdAndDataStatus((long)2, (short) 1));

           userTickets.setUsers(user);
           userTickets.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus(clientTicketRequest.getServiceUnitId(), (short) 1));
           userTickets.setReceiveDate(LocalDateTime.now());
           userTickets=userTicketRepository.save(userTickets);
           return NewTicketResponse.builder()
                   .ticketNo(getQueNumber.getQueNumber(clientTicketDto.getLabel(), clientTicketDto.getNumber().toString()))
                   .ticketTypeName(ticketTypeRepository.findByIdAndDataStatus(clientTicketDto.getTicketTypeId(), (short) 1).getName())
                   .structureName(structureRepository.findByIdAndDataStatus(user.getStructure().getId(),(short) 1).getName())
                   .userTicketId(userTickets.getId())
                   .queOrder(queTicketRepository.countByStructureIdAndServiceIdAndTicketTypeIdAndDataStatusAndDateTimeAfterOrderByDateTimeDesc(
                           user.getStructure().getId(),
                           queTicketRepository.getById(clientTicketDto.getQueTicketId()).getService().getId(),
                           clientTicketDto.getTicketTypeId(),
                           (short) 1,
                           userTickets.getReceiveDate()))
                   .build();
       }
       return null;
    }
}
