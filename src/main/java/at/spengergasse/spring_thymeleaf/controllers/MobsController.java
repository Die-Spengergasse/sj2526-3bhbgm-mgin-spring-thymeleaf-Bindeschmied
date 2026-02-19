package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.MobRepository;
import at.spengergasse.spring_thymeleaf.entities.Mobs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mob")
public class MobsController {
    private final MobRepository mobRepository;
    public MobsController(MobRepository mobRepository) {this.mobRepository = mobRepository;}

    @GetMapping("/list")
    public String mobs(Model model) {
        model.addAttribute("mob", mobRepository.findAll());
        return "moblist";
    }

    @GetMapping("/add")
    public String addMob(Model model) {
        model.addAttribute("mob", new Mobs());
        return "add_mob";
    }

    @PostMapping("/add")
    public String addMob(@ModelAttribute("mob") Mobs mob) {
        mobRepository.save(mob);
        return "redirect:/mob/list";
    }

    @GetMapping("/delete")
    public String deleteMob(int id) {
        mobRepository.deleteMobsById(id);
        return "delete_mob";
    }

}
