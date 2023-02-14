package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Departement;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.repositories.IDepartementsRepository;
import tn.esprit.kaddemspringbootproject.repositories.IUniversiteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartementServices implements IDepartementServices{
    private final IDepartementsRepository departementRepository;
    //private final IEtudiantsRepository etudiantsRepository;
    private final IUniversiteRepository universiteRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {

        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {

        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public void assignEtudiantToDepartement(Integer idDepart,Integer idEtud) {
      /*  Etudiants etudiant=etudiantsRepository.findById(idEtud).orElse(null);
        Departements departement=retrieveDepartement(idDepart);
        etudiant.setDepartements(departement);//aff
        etudiantsRepository.save(etudiant);//sauvg*/

    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite univ=universiteRepository.findById(idUniversite).orElse(null);
        Set<Departement> departements =new HashSet<>();
        departements=univ.getDepartements();
        List<Departement> ListDepartments = new ArrayList<>();
        ListDepartments.addAll(departements);
        //ListDepartments = departements.stream().collect(Collectors.toList());
        return  ListDepartments;
    }

    @Override
    public void removeDepartment(Integer idDepartment) {
        departementRepository.deleteById(idDepartment);
    }

}
