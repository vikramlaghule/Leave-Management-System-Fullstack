package com.example.leaveMS_server.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeaveType type;

    private int days;
    private LocalDate appliedDate = LocalDate.now();
    private boolean approved;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public LeaveRequest() {}

    public LeaveRequest(LeaveType type, int days, User user) {
        this.type = type;
        this.days = days;
        this.user = user;
        this.appliedDate = LocalDate.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LeaveType getType() { return type; }
    public void setType(LeaveType type) { this.type = type; }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }

    public LocalDate getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
