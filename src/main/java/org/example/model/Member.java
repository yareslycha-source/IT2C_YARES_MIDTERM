package org.example.model;

public class Member {
    private int id;
    private String fullName;
    private String tier;
    private double monthlyFee;
    private String status;

    public Member(int id, String fullName, String tier, double monthlyFee, String status) {
        this.id = id;
        this.fullName = fullName;
        this.tier = tier;
        this.monthlyFee = monthlyFee;
        this.status = status;
    }

    public Member(String fullName, String tier, double monthlyFee, String status) {
        this.fullName = fullName;
        this.tier = tier;
        this.monthlyFee = monthlyFee;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getTier() { return tier; }
    public void setTier(String tier) { this.tier = tier; }

    public double getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(double monthlyFee) { this.monthlyFee = monthlyFee; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}