package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Contrat;
import tn.esprit.kaddemspringbootproject.repositories.IContratDao;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContratServices implements IContratServices{

    private final IContratDao iContratDao ;

    @Override
    public List<Contrat> findAll() {
        return  iContratDao.findAll();
    }

    @Override
    public Contrat addOrUpdateContrat(Contrat ce) {
        return iContratDao.save(ce);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        iContratDao.deleteById(idContrat);
    }
}
