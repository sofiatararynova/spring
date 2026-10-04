package ru.kafpin.prakti1;

public class Student {
    private long id;
    private String name;
    private String lastname;
    private String patronomic;
    private String email;
    private Integer year;
    //private String group;

//Getters and setters

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
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
}
