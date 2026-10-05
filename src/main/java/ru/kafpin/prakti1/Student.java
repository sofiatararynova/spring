package ru.kafpin.prakti1;

import jakarta.persistence.*;

@Entity
@Table(name = "students")

public class Student {

    public Student() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String patronomic;
    private String email;
    @Column(name = "study_year")
    private Integer year;
    //private String group;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

//    cascade orphanRemoval = true;

//Getters and setters

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronomic() {
        return patronomic;
    }

    public String getEmail() {
        return email;
    }

    public Integer getYear() {
        return year;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPatronomic(String patronomic) {
        this.patronomic = patronomic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

//    public void setGroup(String group) {
//        this.group = group;
//    }

    public String getGroup() {
        if (year == null) return "";
        return "ПИН-1" + (year % 100);
    }

    public String getLogin() {
        return "student-" + getGroup() + "-" + id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
