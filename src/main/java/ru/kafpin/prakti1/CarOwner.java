package ru.kafpin.prakti1;

import jakarta.persistence.*;

@Entity
@Table(name = "car_owners")
public class CarOwner {
    public CarOwner() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastname;
    private String name;
    private String patronymic;
    private String phone;
    private String carBrand;
    private String carNumber;
    private String techPassport;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getCarBrand() { return carBrand; }

    public void setCarBrand(String carBrand) { this.carBrand = carBrand; }

    public String getCarNumber() { return carNumber; }

    public void setCarNumber(String carNumber) { this.carNumber = carNumber; }

    public String getTechPassport() { return techPassport; }

    public void setTechPassport(String techPassport) { this.techPassport = techPassport; }

}