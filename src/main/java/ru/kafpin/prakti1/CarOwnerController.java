package ru.kafpin.prakti1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kafpin.prakti1.repository.CarOwnerRepository;

import java.util.Optional;

@Controller
@RequestMapping("/owners")
public class CarOwnerController {

    private final CarOwnerRepository repository;

    public CarOwnerController(CarOwnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/main")
    public String list(Model model) {
        model.addAttribute("owners", repository.findAll());
        return "owners-list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("owner", new CarOwner());
        return "owner-form";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<CarOwner> opt = repository.findById(id);
        if (opt.isEmpty()) return "redirect:/owners/main";
        model.addAttribute("owner", opt.get());
        return "owner-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CarOwner owner) {
        repository.save(owner);
        return "redirect:/owners/main";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return "redirect:/owners/main";
    }
}