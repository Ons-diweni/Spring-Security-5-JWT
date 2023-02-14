package tn.esprit.kaddemspringbootproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Contrat;
import tn.esprit.kaddemspringbootproject.entities.Evenement;
import tn.esprit.kaddemspringbootproject.repositories.IEvenenemtDao;
import tn.esprit.kaddemspringbootproject.services.IContratServices;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/superadmin")
public class SuperadminRestController {

  private final IContratServices iContratServices ;
  private final IEvenenemtDao iEvenenemtDao ;


  //RessourceEndPoint:http://localhost:8085/Kaddem/superadmin/event/getAll
  @GetMapping("/event/getAll")
  public List<Evenement> getAllEvents ()
  { return iEvenenemtDao.findAll();}


  //RessourceEndPoint:http://localhost:8085/Kaddem/superadmin/contrat/addOne
  @PostMapping("/contrat/addOne")
  public Contrat addContrat (@RequestBody Contrat contrat)
  { return iContratServices.addOrUpdateContrat(contrat);}


  //RessourceEndPoint:http://localhost:8085/Kaddem/superadmin/contrat/getAll
  @GetMapping("/contrat/getAll")
    public List<Contrat> getAllContrats ()
    { return iContratServices.findAll();}


}
