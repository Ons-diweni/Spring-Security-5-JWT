package tn.esprit.kaddemspringbootproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Evenement;
import tn.esprit.kaddemspringbootproject.repositories.IEvenenemtDao;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EvenementRestController {

    private final IEvenenemtDao iEvenenemtDao ;

    //RessourceEndPoint:http://localhost:8085/Kaddem/event/addEvent
    @PostMapping("/addEvent")
    public void addEvent (@RequestBody Evenement event)
    { iEvenenemtDao.save(event); }


}
