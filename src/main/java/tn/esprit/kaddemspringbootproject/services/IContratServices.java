package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Contrat;

import java.util.List;

public interface IContratServices {

    public List<Contrat> findAll ();
    Contrat addOrUpdateContrat (Contrat ce);
    void removeContrat(Integer idContrat);






}
