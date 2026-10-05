package ru.kafpin.prakti1;

import jakarta.persistence.*;

import java.util.List;

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
        student.setDepartment(this); //FK пишет владелец
    }
    public void removeStudent(Student student) {
        students.remove(student);
        student.setDepartment(null);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
