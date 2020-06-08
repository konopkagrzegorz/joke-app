package guru.springframework.jokeapp.controllers;

import guru.springframework.jokeapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
    @GetMapping({"/",""})
    public String showRandomJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }
}
