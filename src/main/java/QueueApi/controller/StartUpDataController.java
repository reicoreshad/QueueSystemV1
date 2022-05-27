package QueueApi.controller;

import QueueApi.service.StartUpDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/startup")
public class StartUpDataController {
    private  final StartUpDataService startUpDataService;

    public StartUpDataController(StartUpDataService startUpDataService) {
        this.startUpDataService = startUpDataService;
    }

    @GetMapping("/adddata")
    public void addData(){
        startUpDataService.startupData();
    }
}
