package QueueApi.service;

import QueueApi.dao.entity.*;
import QueueApi.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataServiceImpl implements StartUpDataService{
    @Autowired
    StructureRepository structureRepository;
    @Autowired
    ServiceUnitRepository serviceUnitRepository;
    @Autowired
    TicketTypeRepository ticketTypeRepository;
    @Autowired
    ServiceUnitTicketTypeRepository serviceUnitTicketTypeRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    UserTypeRepository userTypeRepository;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void startupData() {
        Structure structure= new Structure();
        ServiceUnit serviceUnit=new ServiceUnit();
        TicketType ticketType=new TicketType();
        ServiceUnitTicketType serviceUnitTicketType=new ServiceUnitTicketType();
        Status status=new Status();
        Services services=new Services();
        UserType userType=new UserType();
        Users users=new Users();

        serviceUnit.setName("Operator 1");
        serviceUnit.setStructure(structureRepository.findByIdAndDataStatus((long)1, (short) 1));
        serviceUnit.setMonitorIp("192.168.1.1");
        serviceUnit.setSysIp("127.0.0.1");
        serviceUnitRepository.save(serviceUnit);
        serviceUnit.setName("Operator 2");
        serviceUnit.setStructure(structureRepository.findByIdAndDataStatus((long)1, (short) 1));
        serviceUnit.setMonitorIp("192.168.1.2");
        serviceUnit.setSysIp("127.0.0.2");
        serviceUnitRepository.save(serviceUnit);
        serviceUnit.setName("Operator 3");
        serviceUnit.setStructure(structureRepository.findByIdAndDataStatus((long)1, (short) 1));
        serviceUnit.setMonitorIp("192.168.1.3");
        serviceUnit.setSysIp("127.0.0.3");
        serviceUnitRepository.save(serviceUnit);
        serviceUnit.setName("Operator 4");
        serviceUnit.setStructure(structureRepository.findByIdAndDataStatus((long)1, (short) 1));
        serviceUnit.setMonitorIp("192.168.1.4");
        serviceUnit.setSysIp("127.0.0.4");
        serviceUnitRepository.save(serviceUnit);

        structure.setName("2-ci Xidmət Sahəsi");
        structureRepository.save(structure);

        ticketType.setName("Satış");
        ticketType.setTicketPriority((short) 1);
        ticketType.setLabel("S");
        ticketType.setNameRu("");
        ticketType.setNameEn("");
        ticketTypeRepository.save(ticketType);
        ticketType.setName("Geri Qaytarma");
        ticketType.setTicketPriority((short) 2);
        ticketType.setLabel("G");
        ticketType.setNameRu("");
        ticketType.setNameEn("");
        ticketTypeRepository.save(ticketType);
        ticketType.setName("Onlayn xidmətlər");
        ticketType.setTicketPriority((short) 3);
        ticketType.setLabel("O");
        ticketType.setNameRu("");
        ticketType.setNameEn("");
        ticketTypeRepository.save(ticketType);
        ticketType.setName("Məlumat");
        ticketType.setTicketPriority((short) 4);
        ticketType.setLabel("M");
        ticketType.setNameRu("");
        ticketType.setNameEn("");
        ticketTypeRepository.save(ticketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)1,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)1,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)1,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)2,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)1,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)3,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)1,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)4,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)2,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)1,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)2,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)2,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);
        serviceUnitTicketType.setServiceUnit(serviceUnitRepository.findByIdAndDataStatus((long)2,(short)1));
        serviceUnitTicketType.setTicketType(ticketTypeRepository.findByIdAndDataStatus((long)3,(short)1));
        serviceUnitTicketTypeRepository.save(serviceUnitTicketType);


        status.setName("Növbədə olan");
        status.setQueStatus((short) 1);
        statusRepository.save(status);
        status.setName("Qəbul edilən");
        status.setQueStatus((short) 1);
        statusRepository.save(status);
        status.setName("Gözləmədə olan");
        status.setQueStatus((short) 1);
        statusRepository.save(status);
        status.setName("Həll edilən");
        status.setQueStatus((short) 1);
        statusRepository.save(status);

        services.setName("Canlı Növbə");
        servicesRepository.save(services);
        services.setName("Online Növbə");
        servicesRepository.save(services);

        userType.setName("Admin");
        userTypeRepository.save(userType);
        userType.setName("Baş Operator");
        userTypeRepository.save(userType);
        userType.setName("Operator");
        userTypeRepository.save(userType);
        userType.setName("Xəzinədar");
        userTypeRepository.save(userType);

        users.setName("Nigar");
        users.setSurname("Rzayeva");
        users.setUserName("n.rzayeva");
        users.setUserPassword("123456");
        users.setStructure(structureRepository.findByIdAndDataStatus((long)1,(short)1));
        users.setUserType(userTypeRepository.findByIdAndDataStatus((long)1,(short)1));
        usersRepository.save(users);


    }
}
