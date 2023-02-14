package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Evenement;

import java.util.List;

public interface IEvenementServices {

    Evenement addOrSaveOne (Evenement event);
    void deleteOneById (Integer idEvent);

    List<Evenement> getAll ();

    List<Evenement> getEventsByUniv ( String nomUniv);

    public Evenement AddEventAddUnivAndAffect (Evenement evenement);

}
