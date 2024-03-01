package com.project.appseller.dtos;

import com.project.appseller.models.Seller;

public class SellerRequestDTO {

    private String name;
    private double salary;
    private double bonus;
    private int gender;

    public SellerRequestDTO() {}

    public SellerRequestDTO(String name, double salary, double bonus, int gender) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Seller toEntity() {
        
        return new Seller(name, salary, bonus, gender);
    }
}
