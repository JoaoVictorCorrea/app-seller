package com.project.appseller.dtos;

import com.project.appseller.models.Seller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SellerRequestDTO {

    @NotBlank(message = "Name can not be blank")
    @Size(min = 5, max = 255, message = "Name length min=5 and max=255")
    private String name;

    @Min(value = 1, message = "Salary min value = 1")
    private double salary;

    @Min(value = 0, message = "Bonus min value = 0")
    @Max(value = 100, message = "Bonus max value = 100")
    private double bonus;

    @Min(value = 0, message = "Gender min value = 0 (Female)")
    @Max(value = 1, message = "Bonus max value = 1 (Male)")
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
