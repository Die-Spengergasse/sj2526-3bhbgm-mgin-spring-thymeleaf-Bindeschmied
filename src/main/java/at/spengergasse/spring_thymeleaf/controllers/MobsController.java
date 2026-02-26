package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.MobRepository;
import at.spengergasse.spring_thymeleaf.entities.Mobs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mob")
public class MobsController {
    private final MobRepository mobRepository;
    public MobsController(MobRepository mobRepository) {this.mobRepository = mobRepository;}

    @GetMapping("/list")
    public String mobs(Model model) {
        model.addAttribute("mob", mobRepository.findAll()); // sucht alle mobs
        return "moblist"; // weist auf die moblist datei
    }

    @GetMapping("/add")
    public String addMob(Model model) {
        model.addAttribute("mob", new Mobs()); // fügt neuen mob ein
        return "add_mob"; // weißt auf add_mob datei
    }

    @PostMapping("/add")
    public String addMob(@ModelAttribute("mob") Mobs mob) {
        mobRepository.save(mob); // speichert den Mob der in der anderen Methode eingefügt wurde
        return "redirect:/mob/list"; // geht zurück zur liste
    }

    @GetMapping("/delete")
    public String deleteMob(@RequestParam int id) {
        Mobs m = mobRepository.findById(id).get(); // sucht mob der zum löschen ist
        mobRepository.delete(m); // löscht mob
        return "redirect:/mob/list";
    }

    @GetMapping("/edit")
    public String editMob(Model model, @RequestParam int id) {
        Mobs m = mobRepository.findById(id).get(); // sucht mob der zum ändern ist
        model.addAttribute("mob", m); // ändert mob
        return "add_mob";
    }

}
