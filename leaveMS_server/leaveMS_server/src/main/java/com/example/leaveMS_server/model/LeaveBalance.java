package com.example.leaveMS_server.model;

import jakarta.persistence.*;
@Entity
public class LeaveBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int casualLeaves = 10;
    private int paidLeaves = 10;
    private int sickLeaves = 10;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public LeaveBalance() {}

    public LeaveBalance(User user) {
        this.user = user;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getCasualLeaves() { return casualLeaves; }
    public void setCasualLeaves(int casualLeaves) { this.casualLeaves = casualLeaves; }

    public int getPaidLeaves() { return paidLeaves; }
    public void setPaidLeaves(int paidLeaves) { this.paidLeaves = paidLeaves; }

    public int getSickLeaves() { return sickLeaves; }
    public void setSickLeaves(int sickLeaves) { this.sickLeaves = sickLeaves; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}