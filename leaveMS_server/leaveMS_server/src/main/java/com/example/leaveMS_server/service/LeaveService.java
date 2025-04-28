package com.example.leaveMS_server.service;

import com.example.leaveMS_server.model.LeaveRequest;
import com.example.leaveMS_server.model.LeaveBalance;
import com.example.leaveMS_server.repository.LeaveBalanceRepository;
import com.example.leaveMS_server.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    public LeaveRequest applyLeave(LeaveRequest request) {
        LeaveBalance balance = leaveBalanceRepository.findByUserId(request.getUser().getId());
        boolean approved = false;

        switch (request.getType()) {
            case PAID:
                approved = balance.getPaidLeaves() >= request.getDays();
                break;
            case SICK:
                approved = balance.getSickLeaves() >= request.getDays();
                break;
            case CASUAL:
                approved = balance.getCasualLeaves() >= request.getDays();
                break;
        }

        if (approved) {
            switch (request.getType()) {
                case PAID:
                    balance.setPaidLeaves(balance.getPaidLeaves() - request.getDays());
                    break;
                case SICK:
                    balance.setSickLeaves(balance.getSickLeaves() - request.getDays());
                    break;
                case CASUAL:
                    balance.setCasualLeaves(balance.getCasualLeaves() - request.getDays());
                    break;
            }
            leaveBalanceRepository.save(balance);
            request.setApproved(true);;
        } else {
        	request.setApproved(false);
        }

        return leaveRequestRepository.save(request);
    }



    public List<LeaveRequest> getLeaveHistory(Long userId) {
        return leaveRequestRepository.findByUserId(userId);
    }

    public LeaveBalance getLeaveBalance(Long userId) {
        return leaveBalanceRepository.findByUserId(userId);
    }

    public List<LeaveRequest> getAllRequests() {
        return leaveRequestRepository.findAll();
    }
}
