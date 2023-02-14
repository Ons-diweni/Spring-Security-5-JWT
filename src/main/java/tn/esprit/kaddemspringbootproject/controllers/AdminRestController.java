package tn.esprit.kaddemspringbootproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.kaddemspringbootproject.entities.Departement;
import tn.esprit.kaddemspringbootproject.entities.Evenement;
import tn.esprit.kaddemspringbootproject.services.IEvenementServices;
import tn.esprit.kaddemspringbootproject.services.IUserServices;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private final IUserServices userServices ;
    private final IEvenementServices iEvenementServices ;


    //RessourceEndPoint:http://localhost:8085/Kaddem/admin/event/getAllByUniv
    @GetMapping("/event/getAllByUniv")
    public List<Evenement> getAllEventByUniv (String nomUniv)
    { return  iEvenementServices.getEventsByUniv(nomUniv);}





}
