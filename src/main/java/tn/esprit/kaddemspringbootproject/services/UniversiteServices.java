package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Departement;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.repositories.IDepartementsRepository;
import tn.esprit.kaddemspringbootproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServices implements IUniversiteServices{
    private final IUniversiteRepository ur;
    private final IDepartementsRepository departementsRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return ur.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return ur.findById(idUniversite).orElse(null);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite univ=retrieveUniversite(idUniversite);
        Departement department=departementsRepository.findById(idDepartement).orElse(null);
        univ.getDepartements().add(department);
        /*Set<Departements> departements =new HashSet<>();
        departements.add(department);
        univ.setDepartements(departements);*/
        ur.save(univ);
    }

    @Override
    public void removeUniv(Integer idUniv) {
        ur.deleteById(idUniv);
    }
}
