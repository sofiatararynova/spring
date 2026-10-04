package ru.kafpin.prakti1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kafpin.prakti1.repository.StudentRepository;

import java.util.Optional;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/institut")
    public String list(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Optional<Student> opt = studentRepository.findById(id);
        if (opt.isEmpty()) return "redirect:/institut";
        model.addAttribute("selectedStudent", opt.get());
        return "details";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "edit_student";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<Student> opt = studentRepository.findById(id);
        if (opt.isEmpty()) return "redirect:/institut";
        model.addAttribute("student", opt.get());
        return "edit_student";
    }

    @PostMapping("/update")
    public String save(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/institut";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
        return "redirect:/institut";
    }
}
