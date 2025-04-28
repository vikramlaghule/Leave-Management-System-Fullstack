package com.example.leaveMS_server.controller;

import com.example.leaveMS_server.model.LeaveBalance;
import com.example.leaveMS_server.model.LeaveRequest;
import com.example.leaveMS_server.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/apply")
    public LeaveRequest applyLeave(@RequestBody LeaveRequest request) {
        return leaveService.applyLeave(request);
    }

    @GetMapping("/balance/{userId}")
    public LeaveBalance getBalance(@PathVariable Long userId) {
        return leaveService.getLeaveBalance(userId);
    }

    @GetMapping("/history/{userId}")
    public List<LeaveRequest> getHistory(@PathVariable Long userId) {
        return leaveService.getLeaveHistory(userId);
    }
}
