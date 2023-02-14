package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Departement;

import java.util.List;

public interface IDepartementServices {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement (Departement d);
    Departement updateDepartement (Departement d);
    Departement retrieveDepartement (Integer idDepart);
    void assignEtudiantToDepartement(Integer idDepart,Integer idEtud);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
    public void removeDepartment(Integer idDepartment);
}
