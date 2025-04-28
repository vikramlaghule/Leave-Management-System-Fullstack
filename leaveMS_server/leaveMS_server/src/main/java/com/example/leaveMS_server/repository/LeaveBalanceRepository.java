package com.example.leaveMS_server.repository;

import com.example.leaveMS_server.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {
    LeaveBalance findByUserId(Long userId);
}
