package com.example.leaveMS_server.controller;

import com.example.leaveMS_server.model.LeaveRequest;
import com.example.leaveMS_server.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/requests")
    public List<LeaveRequest> getAllRequests() {
        return leaveService.getAllRequests();
    }
}
