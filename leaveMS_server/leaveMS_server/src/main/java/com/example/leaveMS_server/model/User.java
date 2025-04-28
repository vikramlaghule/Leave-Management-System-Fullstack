package com.example.leaveMS_server.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users") 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String username;
    private String password;
    private String department;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LeaveBalance leaveBalance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LeaveRequest> leaveRequests;

    public User() {}

    public User(String name, String email, String username, String password, String department) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public LeaveBalance getLeaveBalance() { return leaveBalance; }
    public void setLeaveBalance(LeaveBalance leaveBalance) { this.leaveBalance = leaveBalance; }

    public List<LeaveRequest> getLeaveRequests() { return leaveRequests; }
    public void setLeaveRequests(List<LeaveRequest> leaveRequests) { this.leaveRequests = leaveRequests; }
}
